use booking_tour;

insert into role(name)
values("Thành Viên"),("Nhân Viên");

insert into account(name_account, password,role_id)
values ("admin","123456",2),
("bao","123456",1);

insert into detail_account(date,email,identify,is_delete,name,phone,account_id)
values("2001-02-11","admin@gmai.com",191918176,0,"Admin","0123456789",1),
	  ("2001-02-11","bao@gmai.com",191918176,0,"Bao","0123456789",2);
      
INSERT INTO price (adult_price,children_price,is_delete,type_tour)
values(500000,300000,0,1),(600000,400000,0,2),(700000,500000,0,3);

insert into tour (description, is_delete, name,quantity,image, price_id)
values(" Sapporo là thành phố đăng cai tổ chức Thế vận hội mùa đông đầu tiên ở châu Á vào năm
                                1972 và Lễ hội tuyết Sapporo hàng năm làm du khách từ khắp nơi trên thế giới không khỏi
                                ngây ngất. Sắc xanh của cây lá và hình ảnh trăm hoa đua nở ở Sapporo vào những mùa khác
                                cũng không kém phần ngoạn mục. Thành phố trẻ và rộng mở này cũng nổi tiếng về bia, thịt
                                bò, mì ramen, hải sản và rau củ tươi.",0,"Tour Sapporo",15,"https://res.cloudinary.com/jnto/image/upload/w_750,h_503,fl_lossy,f_auto/v1515928028/hokkaido/Hokkaido1368_2",1),
                                ("  Là trung tâm chính quyền ở Osaka, Nakanoshima là lát cắt đẹp mắt và được thiết kế phù
                                hợp của thành phố. Nakanoshima là nơi có tòa thị chính, một số bảo tàng và các công
                                trình lịch sử
                                và công viên xinh đẹp để đi dạo. Hãy đến đây khi thời tiết ôn hòa để tận hưởng
                                chuyến tản bộ thư giãn, dừng chân tại các bảo tàng và nhiều điểm tham quan trên đường
                                đi.",0,"Osaka",20,"https://songhantourist.com/upload/articles-images/images/Ve-dep-hien-dai-va-yen-binh-tai-osaka-nhat-ban.jpg",2),
                                (" Thành phố Kyoto thu hút hàng triệu du khách địa phương và quốc tế mỗi năm đến đây để tìm
                                kiếm văn hóa Nhật Bản truyền thống.
                                Nổi tiếng là nơi gìn giữ vẻ đẹp hoàng gia của Đế Quốc Nhật những năm 794-1868, thành phố
                                Kyoto ngày nay vẫn còn lưu giữ những ngôi nhà, cung điện, đền chùa mang đậm phong cách
                                thiết kế truyền thống lịch sử.",0,"Kyoto",10,"https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Pedestrian_road_with_pavements%2C_paper_umbrellas_and_people_in_yukata%2C_Higashiyama-ku%2C_Kyoto%2C_Japan.jpg/250px-Pedestrian_road_with_pavements%2C_paper_umbrellas_and_people_in_yukata%2C_Higashiyama-ku%2C_Kyoto%2C_Japan.jpg",3);
                                
insert into img (img,is_delete,name,type_img,tour_id)
values('https://res.klook.com/image/upload/c_fill,w_550,h_308/fl_lossy.progressive,q_85/activities/5dcdc32f-Hokkaido-Otaru-Rickshaw-Tour.webp',0,'Sở Thú Asahikawa',1,1),
('https://res.klook.com/image/upload/c_fill,w_550,h_308/fl_lossy.progressive,q_85/activities/whe4z0utkdcdoadxv3iw.webp',0,'Tour Xe Kéo Ở Otaru,0,Hokkaido',1,1),
('https://res.klook.com/image/upload/c_fill,w_550,h_308/fl_lossy.progressive,q_85/activities/gaplqtper5oci3koyzj6.webp',0,'Tour Đi Tàu Phá Băng Garinko',1,1),
('https://res.klook.com/image/upload/c_fill,w_550,h_308/fl_lossy.progressive,q_85/activities/mq0brcss8v0wp3a4d89q.webp',0,'Chuyến Đi Ngắm Cảnh Núi Moiwa',1,1),
('https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/az8br3r50gcrccqea1bj.webp',0,'Tour Khu Nghỉ Dưỡng Trượt Tuyết Biwako Valley',2,2),
('https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/ajpsbmsv2gigloas7gzc.webp',0,'1 Ngày Tham Quan Nara, Chùa Todaiji Và Chợ Kuroshio',2,2),
('https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/gndogtxqtaxjukqywfsk.webp',0,'Đi Tàu Arashiyama Và Đi Thuyền Trên Sông Hozugawa',2,2),
('https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/ehl1ufar1zrb02sgursk.webp',0,'Tham Quan 1 Đêm Độc Đáo Tại Thành Phố Osaka',2,2),
('https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/xqvgkqrwlgpczbmnmih1.webp',0,'Tham Quan Và Khám Phá Chùa Ở Kyoto',3,3),
('https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/lvyncigbp8jwgz3djbcx.webp',0,'Tham Quan Nara Từ Kyoto',3,3),
('https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/diiiifastnlz9lyqt4mq.webp',0,'Khám Phá Khu Du Lịch Nghỉ Dưỡng Trượt Tuyết Hakodateyama Từ Kyoto',3,3),
('https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/uvmd09hei8xdnreummxa.webp',0,'1 Ngày Ngắm Cảnh Amanohashidate Và Thị Trấn Ine',3,3);

insert into location_tour (date,is_delete,location,type_tour,tour_id)
VALUES ('2001-02-11 00:00:00.000000',0,'Sở Thú Asahikawa',1,1),
('2001-02-11 00:00:00.000000',0,'Tour Xe Kéo Ở Otaru, Hokkaido',1,1),
('2001-02-11 00:00:00.000000',0,'Tour Đi Tàu Phá Băng Garinko',1,1),
('2001-02-11 00:00:00.000000',0,'Chuyến Đi Ngắm Cảnh Núi Moiwa',1,1);

insert into booking (adult_number,children_number,date,is_delete,account_id,price_id,tour_id)
VALUES (5,5,'2001-02-11 00:00:00.000000',0,2,1,1),
(6,6,'2001-02-11 00:00:00.000000',0,2,2,2),
(7,7,'2001-02-11 00:00:00.000000',0,2,3,3);

insert into detail_persont_tour (is_delete,tour_guide,booking_id)
VALUES (0,'Kiet',1),
(0,'Toai',2),
(0,'ThaiBao',3);

insert into payment (status,booking_id)
values(0,1),(0,2),(0,3);