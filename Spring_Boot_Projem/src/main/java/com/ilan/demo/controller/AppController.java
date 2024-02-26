package com.ilan.demo.controller;


import com.ilan.demo.business.IAdService;
import com.ilan.demo.business.ICityService;
import com.ilan.demo.business.IUserService;
import com.ilan.demo.dto.AdDto;
import com.ilan.demo.entity.*;
import com.ilan.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class AppController {

    private IAdService adService;
    private ICityService cityService;

    private IUserRepository userRepository;

    private IUserService userService;

    @Autowired
    public AppController(IAdService adService, ICityService cityService, IUserRepository userRepository, IUserService userService) {
        this.adService = adService;
        this.cityService = cityService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/ad")
    public String showAds(Model model){
        List<Ad> adList= adService.getAll();
        model.addAttribute("ad_list", adList);
        return "home-page";
    }

    @GetMapping("/ad/{id}")
    public String showAd(@PathVariable int id, Model model){
        Ad ad = adService.getById(id);
        model.addAttribute("ad", ad);
        return "ad-page";
    }
    @GetMapping("/city")
    public String showCities(){

        return "cities-page";
    }

    @GetMapping("/city/{name}")
    public String showCityAdList(@PathVariable String name, Model model){
        City city=cityService.getByName(name);
        model.addAttribute("city", city);
        return "city-ad-page";
    }

    @GetMapping("/user/{name}")
    public String showUserAdList(@PathVariable String name, Model model){
        User user = userRepository.getByUserName(name);
        model.addAttribute("user",user);
        return "user-ad-page";
    }

    @GetMapping("/ad/save")
    public String showAdFormPage(Model model){
        model.addAttribute("ad", new AdDto());
        return "ad-form-page";
    }

    @GetMapping("/ad/remove/{id}")
    public String deleteAd(@PathVariable int id)
    {
        adService.delete(id);
        return "redirect:/home/ad";
    }

    @GetMapping("/ad/update/{id}")
    public String updateAdForm(@PathVariable int id, Model model)
    {
        Ad ad=adService.getById(id);
        AdDto adDto=new AdDto();
        adDto.convertToAdDto(ad);
        model.addAttribute("ad", adDto);
        model.addAttribute("id", ad.getId());
        return "ad-update-form";
    }

    @PostMapping("/ad/update/{id}")
    public String updateAd(@PathVariable int id, @ModelAttribute("ad") AdDto adDto)
    {
        Ad ad = adDto.convertToAd(new Ad(), id);
        Ad oldAd= adService.getById(id);
        oldAd.setPrice(ad.getPrice());
        oldAd.setCity(ad.getCity());
        oldAd.setDescription(ad.getDescription());
        oldAd.setAdtypelist(ad.getAdtypelist());
        adService.update(oldAd);
        return "redirect:/home/ad";
    }

    @PostMapping("/ad/save/process")
    public String adSaveProcess(@ModelAttribute("ad") AdDto adDto, @RequestParam("photo")List<MultipartFile> files){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        int id = userRepository.getByUserName(authentication.getName()).getId();
        Ad ad = adDto.convertToAd(new Ad(), id);

        for(MultipartFile file: files) {
            try {
                String filePath = StringUtils.cleanPath(java.util.UUID.randomUUID().toString()) + "_"
                                    + file.getOriginalFilename();

                file.transferTo(new File("C:\\Users\\kosem\\Desktop\\ilan\\src\\main\\resources\\static\\images\\" +filePath));

                Image image= new Image();
                image.setFile_location(filePath);
                ad.addImageToImageList(image);

                image.setImage_owner_ad(ad);

            } catch (IOException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
        adService.save(ad);

        return "redirect:/home/ad";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model theModel) {

        theModel.addAttribute("user", new User());

        return "register-page";
    }


    @PostMapping("/processRegistrationForm")
    public String registerUser(@ModelAttribute("user") User user){
        user.setEnabled(true);
        user.setRole(new Role("ROLE_USER"));
        userService.save(user);
        return "redirect:/home/ad";
    }

}
