use booking_tour;
insert into role(name)
values("Thành Viên"),("Nhân Viên");

insert into account(date,email_client,identify_client,is_delete,name_account,name_client, password,phone_client,role_id)
values ("2001-02-11","admin@gmail.com",191918176,0,"admin","admin","123456","0123456789",2),
("2001-02-11","bao@gmail.com",191918176,0,"bao","bao","123456","0123456789",1),
("2001-02-11","tuan@gmail.com",191918176,0,"tuan","tuan","123456","0123456789",1);
 
insert into tour (adult_price,care_about,children_price,departure_date,description,end_date,image, is_delete, name,quantity,view,tour_guild_id)
values(500000,300,300000,"2024-1-10","Sapporo là thành phố đăng cai tổ chức Thế vận hội mùa đông đầu tiên ở châu Á vào năm
                                1972 và Lễ hội tuyết Sapporo hàng năm làm du khách từ khắp nơi trên thế giới không khỏi
                                ngây ngất. Sắc xanh của cây lá và hình ảnh trăm hoa đua nở ở Sapporo vào những mùa khác
                                cũng không kém phần ngoạn mục. Thành phố trẻ và rộng mở này cũng nổi tiếng về bia, thịt
                                bò, mì ramen, hải sản và rau củ tươi.","2024-1-14","https://res.cloudinary.com/jnto/image/upload/w_
                                750,h_503,fl_lossy,f_auto/v1515928028/hokkaido/Hokkaido1368_2",0,"Tour Sapporo",15,50,1),
                                (600000,200,400000,"2024-2-10","Là trung tâm chính quyền ở Osaka, Nakanoshima là lát cắt đẹp mắt và được thiết kế phù
                                hợp của thành phố. Nakanoshima là nơi có tòa thị chính, một số bảo tàng và các công
                                trình lịch sử
                                và công viên xinh đẹp để đi dạo. Hãy đến đây khi thời tiết ôn hòa để tận hưởng
                                chuyến tản bộ thư giãn, dừng chân tại các bảo tàng và nhiều điểm tham quan trên đường
                                đi.","2024-2-14","https://songhantourist.com/upload/articles-images/images/Ve-dep-hien-dai-va-yen-
                                binh-tai-osaka-nhat-ban.jpg",0,"Osaka",20,40,2),
                                (700000,100,500000,"2024-3-10","Thành phố Kyoto thu hút hàng triệu du khách địa phương và quốc tế mỗi năm đến đây để tìm
                                kiếm văn hóa Nhật Bản truyền thống.
                                Nổi tiếng là nơi gìn giữ vẻ đẹp hoàng gia của Đế Quốc Nhật những năm 794-1868, thành phố
                                Kyoto ngày nay vẫn còn lưu giữ những ngôi nhà, cung điện, đền chùa mang đậm phong cách
                                thiết kế truyền thống lịch sử.","2024-3-14","https://upload.wikimedia.org/wikipedia/commons/thumb/8
                                /86/Pedestrian_road_with_pavements%2C_paper_umbrellas_and_people_in_yukata%2C_Higashiya
                                ma-ku%2C_Kyoto%2C_Japan.jpg/250px-Pedestrian_road_with_pavements%2C_paper_umbrellas_and
                                _people_in_yukata%2C_Higashiyama-ku%2C_Kyoto%2C_Japan.jpg",0,"Kyoto",10,30,3);
                                
insert into location_tour (date,description_location,img,is_delete,location,type_tour,tour_id,tour_day)
VALUES ('2001-02-11 00:00:00.000000',"Từ khách sạn, bạn sẽ được đưa đến Vườn thú Asahiyama để xem hơn 700 con thú khác nhau đại diện cho khoảng 124 loài. Nơi đây có một đường hầm bằng kính đi xuyên qua hồ chim cánh cụt, cũng như các trụ bằng kính nhỏ nằm ngay giữa chuồng gấu bắc cực và sói để bạn có thể ngắm nhìn các loài động vật tuyệt đẹp này ở một khoảng cách gần hơn. Ngoài ra, nếu đến đây tham quan vào mùa đông, bạn còn có cơ hội xem Penguin Walk nữa đấy. Sau khi tham quan sở thú, bạn sẽ tiếp tục hành trình đi ngang qua con đường Pathwork Road, trước khi đến thăm Vườn hoa Kamifurano hoặc Trang trại Tomita, tùy theo mùa. Thật tuyệt vời đúng không nào!",
'https://res.klook.com/image/upload/c_fill,w_550,h_308/fl_lossy.progressive,q_85/activities/5dcdc32f-Hokkaido-Otaru-Rickshaw-Tour.webp',0,'Sở Thú Asahikawa',1,1,1),
('2001-02-11 00:00:00.000000',"Bắt đầu chuyến đi tùy chỉnh của bạn tại nhà ga xe lửa mang tính biểu tượng hoặc tại một trong những cây cầu bắc qua con kênh trung tâm. Khám phá những nét quyến rũ tiềm ẩn của Otaru khi bạn tận hưởng làn gió mùa hè êm dịu hoặc rúc vào người bạn đồng hành của mình khi bạn được hướng dẫn qua những con đường phủ đầy tuyết lãng mạn vào mùa đông. Thưởng thức phong cảnh ngoạn mục từ một điểm thuận lợi cao hơn trong khi chiếc xe kéo của bạn lướt qua các bến tàu, kênh đào và bãi chăn nuôi nguyên sinh.",
'https://res.klook.com/image/upload/c_fill,w_550,h_308/fl_lossy.progressive,q_85/activities/whe4z0utkdcdoadxv3iw.webp',0,'Tour Xe Kéo Ở Otaru, Hokkaido',1,1,2),
('2001-02-11 00:00:00.000000',"Con tàu băng qua được lớp băng là nhờ vào hệ thống máy khoan khổng lồ nghiền nát những khối băng khi nó lướt qua, và thật đúng là một kỳ công của kỹ thuật. Nếu bạn may mắn, bạn thậm chí có thể trông thấy nhiều loài chim và hải cẩu gan dạ chống chọi với cái lạnh trong lúc ở trên tàu."
,'https://res.klook.com/image/upload/c_fill,w_550,h_308/fl_lossy.progressive,q_85/activities/gaplqtper5oci3koyzj6.webp',0,'Tour Đi Tàu Phá Băng Garinko',1,1,3),
('2001-02-11 00:00:00.000000',"Moiwayama nằm cách trung tâm thành phố khoảng 30 phút đi tàu, vào mùa hè, có rất nhiều người đến đây để leo núi, đi bộ đường dài, vào mùa đông lại có nhiều người đến để trượt tuyết.
Cảnh đêm nhìn từ đài quan sát trên đỉnh núi là phong cảnh tuyệt đẹp, được lựa chọn vào “1 trong 3 cảnh đêm đẹp nhất Hokkaido” cùng với núi Hakodate ở thành phố Hakodate và núi Tenguyama ở thành phố Otaru."
,'https://res.klook.com/image/upload/c_fill,w_550,h_308/fl_lossy.progressive,q_85/activities/mq0brcss8v0wp3a4d89q.webp',0,'Chuyến Đi Ngắm Cảnh Núi Moiwa',1,1,4),
('2001-02-11 00:00:00.000000','Tận hưởng một ngày trượt tuyết hoặc chơi tuyết thư giãn tại Biwako Valley Ski Resort
Tận hưởng các hoạt động tuyết dành cho gia đình tại Snow Land như trượt tuyết và trượt phao
Trải nghiệm tuyết trắng như bột ở vùng Kansai và có thể thử làm người tuyết!
Ngắm nhìn khung cảnh ngoạn mục của Hồ Biwa phủ đầy tuyết và Núi Hiei',
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/az8br3r50gcrccqea1bj.webp',0,'Tour Khu Nghỉ Dưỡng Trượt Tuyết Biwako Valley',2,2,1),
('2001-02-11 00:00:00.000000',"Tìm hiểu về lịch sử của Edo và trải nghiệm câu chuyện huyền thoại của gia đình Tokugawa trong chuyến tham quan cổ điển đến Lâu đài Wakayama.
Xem những con cá tươi mới nhất tại Chợ Kuroshio và xem màn trình diễn mổ xẻ cá ngừ sống của một nghệ nhân Nhật Bản hiếm thấy ở Nhật Bản.
Tham quan Chùa Todaiji, Di sản Thế giới và là tòa nhà bằng gỗ lớn nhất thế giới, để trải nghiệm sự tráng lệ của kiến trúc truyền thống
Một chuyến viếng thăm Nara là cơ hội để nhìn thấy một chú hươu mận đáng yêu và trải nghiệm việc cho chúng ăn và chụp ảnh tự sướng với chúng",
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/ajpsbmsv2gigloas7gzc.webp',0,'1 Ngày Tham Quan Nara, Chùa Todaiji Và Chợ Kuroshio',2,2,2),
('2001-02-11 00:00:00.000000',"Hozukyo, trải dài từ Cầu Hozubashi của Thành phố Kameoka đến Cầu Togetsukyo của Arashiyama, tự hào có một số thung lũng đẹp nhất ở Kyoto.
Cây xanh tươi tô màu đẹp đẽ cho thiên nhiên phong phú của thung lũng thật trang nhã. Bạn có thể tận hưởng đầu hè đầy màu sắc♪
Khởi hành và đến Osaka/Kyoto Tour xe buýt trong ngày Xe điện Sagano và đi bè trên sông Hozugawa ♪
Tận hưởng màu sắc của mùa xuân khi một chuyến tàu cổ điển đưa bạn đi trên một chuyến đi nhàn nhã.
Nhảy lên một chiếc thuyền truyền thống và chiêm ngưỡng những cảnh đẹp bắt mắt khi bạn xuôi dòng sông Hozugawa.",
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/gndogtxqtaxjukqywfsk.webp',0,'Đi Tàu Arashiyama Và Đi Thuyền Trên Sông Hozugawa',2,2,3),
('2001-02-11 00:00:00.000000',"Ninomaru (thành lũy bên ngoài) - Honmaru (thành lũy chính) - Nishinomaru ( thành lũy phía Tây). Thời gian tham quan vừa chụp ảnh khu vực này sẽ mất khoảng 1 tiếng rưỡi.
Tòa tháp canh sẽ được tham quan cuối cùng, đây là nơi có nhiều tư liệu trưng bày và nhiều hoạt động thú vị khác. Bạn sẽ mất khoảng 30 phút để tham quan tòa tháp này và đi bằng thang máy nên khá dễ dàng trong việc di chuyển.",
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/ehl1ufar1zrb02sgursk.webp',0,'Tham Quan 1 Đêm Độc Đáo Tại Thành Phố Osaka',2,2,4),
('2001-02-11 00:00:00.000000',"Tuy nơi đây chỉ là vài công trình phòng ngự thời chiến cổ xưa nhưng nó lưu lại tinh hoa kiến trúc cũng như những nét đẹp văn hóa truyền thống của người dân Nhật Bản xưa.
Thành cổ Nijo là một khu thành quách rộng lớn thuộc Kyoto, Nhật Bản. Thành cổ này bao gồm hai vòng tường thành kiên cố, lâu đài Ninomaru, lâu đài Honmaru và vô số dinh thự, vườn cây hoa cảnh lộng lẫy khác.
Ngày nay, thành cổ trở thành địa điểm du lịch Nhật Bản thu hút du khách bốn phương - những người muốn khám phá tìm về với nét đẹp kiến trúc, văn hóa và đời sống cổ xưa xứ sở mặt trời mọc.",
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/xqvgkqrwlgpczbmnmih1.webp',0,'Tham Quan Và Khám Phá Chùa Ở Kyoto',3,3,1),
('2001-02-11 00:00:00.000000',"Hãy đến tham quan đền Fushimi Inari, nơi nổi tiếng với hàng nghìn cánh cổng torii được sơn màu đỏ
Chiêm ngưỡng khung cảnh đẹp như tranh vẽ của Arashiyama, từ bờ sông tĩnh lặng cho đến bầu không khí thanh bình của rừng trúc
Đến chùa Kinkakuji (Chùa Vàng) để ngắm nhìn những bức tường dát vàng
Bạn sẽ có cơ hội cho những chú nai 'gật đầu' ăn ở công viên Nara
Khám phá các bảo vật quốc gia của Nhật Bản như chùa Todai-ji và tượng Phật Daibutsu
Bạn sẽ có một chuyến đi xe đầy thư giãn, thoải mái và tiện lợi cùng hướng dẫn viên nói tiếng Trung Quốc và tiếng Anh",
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/lvyncigbp8jwgz3djbcx.webp',0,'Tham Quan Nara Từ Kyoto',3,3,2),
('2001-02-11 00:00:00.000000',"Tận hưởng một ngày trượt tuyết và trượt ván tuyết thư giãn tại Khu nghỉ dưỡng Trượt tuyết Hakodateyama
Tận hưởng chuyến tham quan bằng xe buýt khứ hồi thuận tiện từ Kyoto!
Kid's World là công viên tuyết thân thiện với gia đình, có lối đi di chuyển được thiết kế dành cho trẻ em không thể tự mình đi cáp treo",
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/diiiifastnlz9lyqt4mq.webp',0,'Khám Phá Khu Du Lịch Nghỉ Dưỡng Trượt Tuyết Hakodateyama Từ Kyoto',3,3,3),
('2001-02-11 00:00:00.000000',"Amanohashidate là một bãi cát ở vịnh Miyazu phía bắc Kyoto, và là một trong Ba thắng cảnh của Nhật Bản
Chùa Chionji nằm ở lối vào phía nam của Amanohashidate, thờ Bồ tát Monju, vị thần trí tuệ của Phật giáo
Ine no Funaya là một làng chài truyền thống ở thị trấn Ine, Kyoto và thường được gọi là Venice của Nhật Bản",
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/uvmd09hei8xdnreummxa.webp',0,'1 Ngày Ngắm Cảnh Amanohashidate Và Thị Trấn Ine',3,3,4);

insert into booking (adult_number,children_number,date,is_delete,account_id,tour_id)
VALUES (5,5,'2001-02-11 00:00:00.000000',0,1,1),
(6,6,'2001-02-11 00:00:00.000000',0,2,2),
(7,7,'2001-02-11 00:00:00.000000',0,3,3);

insert into payment (status,booking_id)
values(0,1),(0,2),(0,3);

insert into tour_guild(date,email_guild,is_delete,name,phone_guild)
values('1999-02-20','tranducphuong@gmail.com',0,'Phuong TD','0912345678'),
('1993-02-20','lamtran@gmail.com',0,'Lam','0912345678'),
('1997-02-20','tronghai@gmail.com',0,'Hai','0912345678'),
('2005-02-20','tieuvi@gmail.com',0,'Vi','0912345678'),
('2002-02-20','dobeo@gmail.com',0,'Do','0912345678');