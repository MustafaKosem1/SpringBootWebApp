Airbnb mantığına benzer bir ilan sitesinin demosu.

Kullanılan teknolojiler; Java Spring Boot, Hibernate, Spring MVC, Thymeleaf, Spring Security, Spring JPA, Mysql, Html/CSS, Bootstrap, Javascript.

Bir şehirdeki yerel kişilerin o şehre turizm ve gezme amaçlı gelen kişilere kalacak yer, yeme içme ve tur(gezdirme) gibi hizmetler sağlamak amacıyla ilan oluşturabilecekleri bir sitedir. Amaç yerel kullanıcıların gelir sağlaması, turistlerin ise daha ucuza hizmet alırken iki tarafın da birbirlerinin kültürlerini tanıma fırsatı yakalamasıdır.

Uygulamada hesap oluşturma, giriş yapma, ilan görüntüleme(tüm ilanları veya şehir, kişi bazlı ilanlar), ilan oluşturma, ilan silme, ilan güncelleme gibi CRUD fonksiyonları bulunmaktadır.
Database olarak Mysql kullanılmıştır. Backend kısmı katmanlı(Repository, Business, Controller) şekilde Spring yapıları kullanılarak yapılmıştır. ORM olarak Hibernate kullanılıp mappingler bu şekilde yapılmıştır. Spring Security ile authorization ve authenticationlar ayarlanmıştır. Frontend kısmında Bootstrap ve Html yardımıyla temel tasarımlar yapılıp, Thymeleaf ile gösterilecek veriler ayarlanmıştır. Ek olarak uygulamada REST endpointler de bulunmaktadır.

Application.properties kısmından database bağlantıları ayarlanarak ve sql-scripts klasöründeki table ve örnek veriler databasede çalıştırılarak uygulama hazırlanıp denenebilir. İlanların içerdiği örnek resimler de yine dosyalarda bulunmaktadır.

Henüz ilk versiyonunda olan geliştirme aşamasındaki bir projedir.
