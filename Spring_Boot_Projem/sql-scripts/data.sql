INSERT INTO `my_database`.`ad_type` (`name`, `description`) VALUES ('Tour', 'Tur, gezdirme hizmeti sağlanıyor.');
INSERT INTO `my_database`.`ad_type` (`name`, `description`) VALUES ('Day', 'Eve gün içinde erişim sağlanabiliyor.');
INSERT INTO `my_database`.`ad_type` (`name`, `description`) VALUES ('Night', 'Gecelik ev hizmeti.');
INSERT INTO `my_database`.`ad_type` (`name`, `description`) VALUES ('Food', 'Yiyecek hizmeti sağlanıyor.');

INSERT INTO `my_database`.`city` (`name`, `description`) VALUES ('İzmir', 'Egenin en büyük kenti ve güzel bir şehir.');
INSERT INTO `my_database`.`city` (`name`, `description`) VALUES ('İstanbul', 'Çok kalabalık  bir şehir. Tarihi yapıları ile ünlü.');
INSERT INTO `my_database`.`city` (`name`, `description`) VALUES ('Malatya', 'Kayısının başkenti, Doğu Anadoluda bulunuyor.');
INSERT INTO `my_database`.`city` (`name`, `description`) VALUES ('Konya', 'İç Anadoluda bulunan bir şehir.');

INSERT INTO `my_database`.`role` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `my_database`.`role` (`name`) VALUES ('ROLE_USER');

INSERT INTO `my_database`.`user` (`id`,`username`,`name`,`surname`,`phone`,`age`,`mail`,`password`,`enabled`,`role`) VALUES (1,'Mustafa123','Mustafa','Kösem','12345678',33,'mustafa@gmail.com','$2a$10$eVIiVJKfYVnpwiVswPP2Zefa4XwgdR8LQs0cFPs5EPIJzwf5UatIu','1','ROLE_USER');
INSERT INTO `my_database`.`user` (`id`,`username`,`name`,`surname`,`phone`,`age`,`mail`,`password`,`enabled`,`role`) VALUES (2,'Ahmet123','Ahmet','Yılmaz','345126423',22,'ahmet@gmail.com','$2a$10$T4lRm21hbgYe0sliYPyWjuhEOWZszvER9Sosl/Me/CKixb7nEcjOC','1','ROLE_USER');
INSERT INTO `my_database`.`user` (`id`,`username`,`name`,`surname`,`phone`,`age`,`mail`,`password`,`enabled`,`role`) VALUES (3,'Ayşe123','Ayşe','Karataş','49875423',45,'ayse@gmail.com','$2a$10$N13dxf5J4r3kOSYt1TzDTO5u3xntSQ9fS6g02AfdQ9gU1476GlqPi','1','ROLE_USER');

INSERT INTO `my_database`.`ad` (`id`,`date`,`ad_owner`,`city_name`,`header`,`description`,`price`) VALUES (1,'2024-02-26',1,'İstanbul','İstanbulda Gecelik Daire','Kendi dairemde bir odamı İstanbul\'a ziyarete gelen kişilere uygun bir fiyata gece kalabilmeleri için açabilirim. Akşam yemeği de fiyata dahildir.',455);
INSERT INTO `my_database`.`ad` (`id`,`date`,`ad_owner`,`city_name`,`header`,`description`,`price`) VALUES (3,'2024-02-26',2,'Malatya','Malatyada Daire','Sadece gündüzleri kalabileceğiniz bir daire. Detaylar için arayın konuşalım. Lütfen indirim istemeyin.',125);
INSERT INTO `my_database`.`ad` (`id`,`date`,`ad_owner`,`city_name`,`header`,`description`,`price`) VALUES (4,'2024-02-26',1,'İzmir','Her Şey Dahil Paket','İzmirde her şey dahil turist paketi. Çok uygun fiyatlı kesinlikle arayın kaçırmayın. Konak merkezinde gezilecek yerlere yakındır.',1000);
INSERT INTO `my_database`.`ad` (`id`,`date`,`ad_owner`,`city_name`,`header`,`description`,`price`) VALUES (5,'2024-02-26',3,'Konya','Konya Müstakil Ev','Müstakil evimde 2 odam boş. Bu odalardan birini gündüz ve gece kiralamak istiyorum. İsterseniz şehri de gezdirebilirim. Fiyat tek odanın fiyatıdır iki kişi gelenler iki katı ödeyecektir.',670);

INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (1,1,'7c23673b-d696-4ff3-95bf-f2d69ae25b6d_douglas-sheppard-9rYfG8sWRVo-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (2,1,'19efb3e3-95cd-4770-875c-225a3a40df50_nathan-fertig-FBXuXp57eM0-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (3,1,'b2dd8101-227c-4df3-818b-4c19b3a7f1aa_r-architecture-wDDfbanbhl8-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (6,3,'604031c9-1c92-4d2a-af3e-0bb165845c00_douglas-sheppard-9rYfG8sWRVo-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (7,3,'82040d46-84b6-45df-838d-001daa384338_nathan-fertig-FBXuXp57eM0-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (8,3,'b9197fcd-527f-4801-b67e-807d86f48436_r-architecture-wDDfbanbhl8-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (9,4,'290ecfe0-35cb-4e32-81ee-91db189b6dbb_r-architecture-wDDfbanbhl8-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (10,4,'2449e311-a030-44fd-b988-9d71b76735d8_spacejoy-uGWNcejbf2E-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (11,5,'f8f2699f-f2d7-4fbb-b2ca-b82ea790dcfb_nathan-fertig-FBXuXp57eM0-unsplash.jpg');
INSERT INTO `my_database`.`image` (`id`,`image_owner_ad`,`file_location`) VALUES (12,5,'3b9b5bd9-d9dc-4b5f-a1fb-7944bc3b00ee_spacejoy-uGWNcejbf2E-unsplash.jpg');

INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (3,'Day');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (4,'Day');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (5,'Day');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (1,'Food');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (4,'Food');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (1,'Night');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (4,'Night');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (5,'Night');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (4,'Tour');
INSERT INTO `my_database`.`ad_ad_type` (`ad_id`,`ad_type`) VALUES (5,'Tour');
