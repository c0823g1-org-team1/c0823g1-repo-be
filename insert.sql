use booking_tour;
insert into role(name)
values("ROLE_ADMIN"),("ROLE_USER");
insert into account(date,email_client,identify_client,is_delete,username,name_client, password,phone_client,role_id)
values ("2001-02-11","admin@gmail.com",191918176,0,"admin","admin","$2a$12$wu9h953gTLVuY/quXJIt6OiWZWWv5ikzXu6UOnfl3UcMEu3wE2H6S","0123546789",2),
("2001-02-11","bao@gmail.com",191918176,0,"bao","baoo","$2a$12$wu9h953gTLVuY/quXJIt6OiWZWWv5ikzXu6UOnfl3UcMEu3wE2H6S","0123457689",1),
("2001-02-11","tuan@gmail.com",191918176,0,"tuan","tuann","$2a$12$wu9h953gTLVuY/quXJIt6OiWZWWv5ikzXu6UOnfl3UcMEu3wE2H6S","0132456789",1);
insert into tour_guild(date,email_guild,is_delete,name,phone_guild)
values('1999-02-20','tranducphuong@gmail.com',0,'Phuong TD','0912345678'),
('1993-02-20','lamtran@gmail.com',0,'Lam','0912345678'),
('1997-02-20','tronghai@gmail.com',0,'Hai','0912345678'),
('2005-02-20','tieuvi@gmail.com',0,'Vi','0912345678'),
('2002-02-20','dobeo@gmail.com',0,'Do','0912345678');
insert into tour (adult_price,care_about,children_price,departure_date,description,end_date,image, is_delete, name,quantity,view,tour_guild_id)
values(500000,300,300000,"2024-1-10","Sapporo là thành phố đăng cai tổ chức Thế vận hội mùa đông đầu tiên ở châu Á vào năm
                               1972 và Lễ hội tuyết Sapporo hàng năm làm du khách từ khắp nơi trên thế giới không khỏi
                                ngây ngất. Sắc xanh của cây lá và hình ảnh trăm hoa đua nở ở Sapporo vào những mùa khác
                                cũng không kém phần ngoạn mục. Thành phố trẻ và rộng mở này cũng nổi tiếng về bia, thịt
                                bò, mì ramen, hải sản và rau củ tươi.","2024-1-14","https://res.cloudinary.com/jnto/image/upload/w_750,h_503,fl_lossy,f_auto/v1515928028/hokkaido/Hokkaido1368_2",0,"Tour Sapporo",15,50,1),
                                (600000,200,400000,"2024-2-10","Là trung tâm chính quyền ở Osaka, Nakanoshima là lát cắt đẹp mắt và được thiết kế phù
                                hợp của thành phố. Nakanoshima là nơi có tòa thị chính, một số bảo tàng và các công
                                trình lịch sử
                                và công viên xinh đẹp để đi dạo. Hãy đến đây khi thời tiết ôn hòa để tận hưởng
                                chuyến tản bộ thư giãn, dừng chân tại các bảo tàng và nhiều điểm tham quan trên đường
                                đi.","2024-2-14","https://songhantourist.com/upload/articles-images/images/Ve-dep-hien-dai-va-yen-binh-tai-osaka-nhat-ban.jpg",0,"Osaka",20,40,2),
                                (700000,100,500000,"2024-3-10","Thành phố Kyoto thu hút hàng triệu du khách địa phương và quốc tế mỗi năm đến đây để tìm
                                kiếm văn hóa Nhật Bản truyền thống.
                                Nổi tiếng là nơi gìn giữ vẻ đẹp hoàng gia của Đế Quốc Nhật những năm 794-1868, thành phố
                                Kyoto ngày nay vẫn còn lưu giữ những ngôi nhà, cung điện, đền chùa mang đậm phong cách
                                thiết kế truyền thống lịch sử.","2024-3-14","https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Pedestrian_road_with_pavements%2C_paper_umbrellas_and_people_in_yukata%2C_Higashiyama-ku%2C_Kyoto%2C_Japan.jpg/250px-Pedestrian_road_with_pavements%2C_paper_umbrellas_and_people_in_yukata%2C_Higashiyama-ku%2C_Kyoto%2C_Japan.jpg",0,"Kyoto",10,30,3),
                                (800000,150,600000,"2024-4-16","Nikko nằm ở tỉnh Tochigi, chỉ cách Thủ đô Tokyo 2 tiếng đi tàu siêu tốc. Đây là một trong những thành phố du lịch nổi tiếng và đẹp nhất Nhật Bản. 
                                Nikko không những có phong cảnh thiên nhiên phong phú, mà còn có những di tích lịch sử lâu năm, đền thờ linh thiêng nổi tiếng. Thời gian đẹp nhất để đến thăm Nikko là mùa thu, 
                                khi tiết trời chuyển mùa, cảnh sắc nhuốm màu vàng óng hay đỏ tươi.",
                                "2024-4-20","https://vn.japo.news/contents/wp-content/uploads/2016/09/Toshogu.jpg",0,"Nikko",10,30,3),
                                (900000,250,700000,"2024-5-26","Thành phố thủ đô là cái tên đầu tiên trong danh sách bởi sự năng động và sầm uất. Nếu ai muốn trải nghiệm Buzz và sự phấn khích 
                                của một Megalopolis chính trên thế giới thì ghé Tokyo là điều lý tưởng. Thành phố sôi động này có qua nhiều điều để bạn trải nghiệm và khám phá.",
                                "2024-5-30","https://vietair.com.vn/Media/Images/vietair/Tin-tuc/2018/12/thanh-pho-du-lich-noi-tieng-nhat-nhat-ban-1.jpg?p=1&w=790",0,"Tokyo",10,30,4),
                                (600000,250,400000,"2024-6-20","Từng được biết đến là một thành phố gánh chịu quả bom nguyên tử nghiệt ngã trong thế chiến thứ hai, song Hiroshima ngày nay đã khoác lên màu áo mới. 
                                Phục hồi nhanh chóng, thành phố này nay đã trở thành một trong những thành phố có nền kinh tế và cả du lịch phát triển. Đến đây, bạn có thể thamquan bảo tàng Về bom nguyên tử- bảo 
                                tàng nổi tiếng trưng bày nhiều hiện vật và tài liệu về tác hại của bom nguyên tử cũng như sự phục hồi nhanh chóng của thành phố.",
                                "2024-6-24","https://vietair.com.vn/Media/Images/vietair/Tin-tuc/2018/12/thanh-pho-du-lich-noi-tieng-nhat-nhat-ban-2.jpg?p=1&w=790",0,"Hiroshima",10,30,2)
                                ;
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
'https://res.klook.com/image/upload/fl_lossy.progressive,w_540,h_360,c_fill,q_85/activities/uvmd09hei8xdnreummxa.webp',0,'1 Ngày Ngắm Cảnh Amanohashidate Và Thị Trấn Ine',3,3,4),
('2024-04-17 00:00:00.000000',"Shimo-imaichi Station đổi tàu qua Nikko line tới Nikko station. Tham quan cầu Shinkyo, cây cầu đỏ chụp hình siêu đẹp đặc biệt vào mùa thu, từ Nikko đi xe buýt tới trạm Shinkyo
Tham quan thác Kegon Falls. Cách đi: từ trạm Shinkyo --> trạm Nikko Lake Side Hotel (¥1050). Tham quan thác, chùa Chuzenji, có thể chọn tắm suối nước nóng ở Nikko Lake Side Hotel. 
Tham quan dạo hồ đẹp nhất Nikko hoặc đi du thuyền ngắm hồ",
'https://phuotvivu.com/blog/wp-content/uploads/2018/12/cau-shinkyo.jpg',0,'Tham quan dạo hồ đẹp nhất Nikko',4,4,1),
('2024-04-18 00:00:00.000000',"Nikko station --> cáp treo Akechidaira đi cáp treo nhớ show bus pass để được giảm giá chỗ này ngắm view thác Kegon & hồ Chuzenji rất đẹp.
Akechidaira --> trạm xe buýt hồ Chuzenji --> đi bộ tới thác Kegon --> đi dạo vòng quanh hồ tới đền Chuzenji temple --> đại sứ quán Ý --> đại sứ quán Anh, đường đi bộ tới các điểm này vào mùa thu rất đẹp. 
Chùa đẹp bên ngoài thôi nên không cần trả 500 yên để vào.",
'https://phuotvivu.com/blog/wp-content/uploads/2019/12/chua-chuzenji-1024x569.jpg',0,'Tham quan chùa Chuzenji',4,4,2),
('2024-04-19 00:00:00.000000',"Từ đại sứ quán Anh đi bus tới núi Hangetsusan, chỗ này ít khách du lịch, núi có view đẹp nhất chụp hình và ngắm trọn hồ Chuzenji, tuy nhiên bạn phải leo tầm
 20 phút để lên tới chỗ ngắm. Giá vé 530 yên/chiều không nằm trong các pass nhỏ nhỏ mà chỉ có gồm trong Nikko All Pass. Đi xe từ Hangetsusan về lại Chuzenji sau đó đi xe khác chuyến 12:45 
 hoặc 13:15 tới Shinkyo bridge, ăn trưa sau đó chụp hình cầu Shinkyo và vào khu đền Tōshōgū, đây là khu đền rất lớn với nhiều điểm tham quan, dù không trả tiền vào đền nhưng đi dạo xung
 quanh cũng rất đẹp, nhiều chỗ chụp hình.",
'https://phuotvivu.com/blog/wp-content/uploads/2019/12/chua-o-nikko-1024x569.jpg',0,'Tham quan núi Hangetsusan',4,4,3),
('2024-04-20 00:00:00.000000',"Sáng đi xe buýt tới thác Ryuzu từ đó đi trekking qua cao nguyên Senjogahara. Chỗ này trekking cực kỳ nhẹ nhàng, trên đường đi Phuotvivu gặp rất nhiều người già,
 cảnh đẹp mê hồn, không đi sẽ vô cùng uổng phí. Sau đó đón xe buýt tới Yumoto Onsen đi bộ vòng quanh hồ Yunoko, hồ này có màu xanh ngọc bích, bao quanh bởi núi, chụp hình cực đẹp, Phuotvivu thích hơn hồ Chuzenji rất nhiều.",
'https://phuotvivu.com/blog/wp-content/uploads/2019/12/ho-yunoto-1024x569.jpg',0,'Trekking cao nguyên và hồ Yunoko',4,4,4),
('2024-05-27 00:00:00.000000',"Đền Asakusa Kannon - một trong những ngôi đền cổ nhất Tokyo vẫn còn lưu lại các di tích cổ và là điểm đặc biệt thu hút người dân Nhật Bản và du khách vào đêm giao thừa cũng như năm mới.
Đoàn tiếp tục khởi hành tham quan Akihabara - thành phố điện tử nằm giữa lòng Tokyo, nơi quý khách có thể mua cho mình những món hàng điện tử giá rẻ hơn bình thường.
Tháp truyền hình Skytree - biểu tượng của Tokyo, Nhật Bản.",
'https://intertour.vn/wp-content/uploads/2022/03/c3511cb3-29d9-4e9b-a4fe-c4c609222cee-1-1536x1023.jpg',0,'KHÁM PHÁ TOKYO',5,5,1),
('2024-05-28 00:00:00.000000',"Sáng : Quý khách dùng điểm tâm sáng tại khách sạn và làm thủ tục trả phòng.
Đoàn trên tour Nhật Bản Tokyo - Kyoto - Osaka 7 ngày 6 đêm, khởi hành đến núi Phú Sĩ - là ngọn núi cao nhất Nhật bản.
Đến nơi, quý khách tham quan cảnh đẹp hồ Ashi bằng du thuyền. Quý khách dùng bữa trưa tại nhà hàng địa phương. 
Chiều : Đoàn tiếp tục tham quan ngôi làng cổ Oshino Hakkai nằm ở chân núi Phú Sĩ. Tại đây, bạn sẽ thấy khu vườn rau xanh mướt quanh ngôi nhà phủ rêu, những luống ngô, đồng hoa cải vàng thật yên bình.
Quý khách thưởng thức bữa tối tại nhà hàng địa phương. Nhận phòng và nghỉ ngơi tại khách sạn. ",
'https://vcdn1-dulich.vnecdn.net/2020/07/09/japanmtfujiandcherryblossoms-1-3441-7744-1594271601.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=ctoMf_xj5MJvGM_XUhtGwA',0,'TOKYO - NÚI PHÚ SĨ ',5,5,2), 
('2024-05-29 00:00:00.000000',"Tokyo thường được biết đến là thành phố với những tòa nhà chọc trời cùng cơ sở vật chất hiện đại là điểm du lịch Tokyo Nhật Bản phổ biến. Nhưng khám phá những khía cạnh lịch sử bên 
trong mới thật sự là điều tuyệt vời mà khách du lịch Tokyo Nhật Bản nên làm. Và phố cổ Yanaka là một viên ngọc ẩn trong lòng Tokyo, nơi vẫn lưu giữ vẻ hoang sơ của những năm tháng xưa cũ.",
'https://intertour.vn/wp-content/uploads/2022/03/29d8d9f9-c201-4376-b988-402afb40a5a4-1.jpg',0,'Phố cổ Yanaka',5,5,3),
('2024-05-30 00:00:00.000000',"Akihabara là khu phố điện tử nổi tiếng hàng đầu Tokyo với hàng trăm cửa hàng điện tử lớn, nhỏ san sát nhau trên đường phố Chuo-dori. Ở đây có nhiều mặt hàng điện tử, 
từ máy vi tính, máy ảnh, tivi, điện thoại di động và các thiết bị điện tử khác từ mới nhất cho đến các mặt hàng cũ được bày bán với giá rẻ.",
'https://intertour.vn/wp-content/uploads/2022/03/135fc740-7e84-4c7b-968a-2a83a5c2809b-1-1536x1020.jpg',0,'Khu phố điện tử Akihabara',5,5,4),
('2024-06-21 00:00:00.000000',"Sau bữa sáng, xe và HDV đón đoàn đi tham quan Đảo Sanin Matsu. Bằng du thuyền cao cấp, quý khách có thể ngắm nhìn khung cảnh của biển Nhật Bản và hình ảnh các đảo gần đó.
Đến tham quan nông trường, đoàn có thể tự tay hái những quả lê chín mọng, thơm ngon với bí quyết kĩ thuật trồng từ hơn 100 năm trước ở tỉnh Tottori. Tại đây có rất nhiều giống lê khác nhau được tuyển 
chọn kỹ càng với hương vị thanh mát và đặc biệt là sự cân bằng giữa vị ngọt và vị chua.",
'https://globaltravel.com.vn/wp-content/uploads/2017/08/Hoa-Anh-Dao-Tokyo-17.jpg',0,'TOTTORI – OKAYAMA',6,6,1),
('2024-06-22 00:00:00.000000',"Đoàn tham quan Vườn Koraku-en, đây là một trong ba khu vườn đẹp nhất Nhật Bản và là niềm tự hào Okayama. Khu vườn Korakuen vẫn lưu giữ mô hình một khu vườn Nhật Bản từ thời 
Edo với những bãi cỏ rộng lớn, thác nước, đồi cây, phòng trà và suối nước róc rách. Đặc biệt, từ Korakuen Garden du khách còn có thể chiêm ngưỡng hình ảnh của Lâu đài Okayama được mệnh danh là lâu đài Quạ 
đen của vùng Okayama. Là lâu đài được xây dựng từ thời Nam Bắc triều, điểm thu hút của lâu đài là lớp sơn màu đen nổi bật hiếm có, ngoại trừ vài máng xối hình cá, các phần đầu nhô của máng được mạ vàng.",
'https://globaltravel.com.vn/wp-content/uploads/2017/08/06_01.jpg',0,'OKAYAMA – HIROSHIMA',6,6,2),
('2024-06-23 00:00:00.000000',"Sau bữa sáng, đoàn tham quan trung tâm Cao nguyên Hiruzen, nằm ở chân ba đỉnh núi lần lượt là Kami, Naka và Shimo và thuộc công viên quốc gia Daisen-Oki. Cao nguyên Hiruzen 
vào mỗi mùa thu đều đặn thay chiếc áo màu đỏ và vàng rực rỡ vô cùng lãng mạn và quyến rũ. Trời thu se lạnh, màu vàng và đỏ rực trải đều phủ khắp miền đồi núi khiến cho du khách đến Nhật Bản sẽ không ít 
lần phải xao xuyến và bị mê hoặc bởi màu sắc thiên nhiên tinh tế, huyền bí, nhưng lại vô cùng thân thiện, đẹp đẽ.",
'https://globaltravel.com.vn/wp-content/uploads/2017/08/khu-tuong-niem-hoa-binh-hiroshima-genbaku-dome.jpg',0,'HIROSHIMA – DAISEN',6,6,3),
('2024-06-24 00:00:00.000000',"Đoàn dùng bữa sáng tại khách sạn, xe và HDV đón đoàn đi tham quan Công viên hoa Tottori Hanakairo. Đây là vườn hoa lớn nhất Nhật Bản, trải dài qua 2 thị trấn dưới chân 
núi Oyama là Houki-cho và Nanbu-cho. Vườn hoa Tottori Hanakairo đều đặn thay đổi chiếc áo đầy sắc màu theo từng mùa trong năm, đặc biệt vào mùa thu, quý khách sẽ được chiêm ngưỡng cánh đồng hoa xác 
pháo đỏ rực, trải dài bất tận bên cạnh những hàng cây đổi màu vô cùng rực rỡ.",
'https://globaltravel.com.vn/wp-content/uploads/2017/08/209-739d152ad3ba9a1136265f932b6b3d3a.jpg',0,'TOTTORI',6,6,4);
insert into booking (adult_number,children_number,date,is_delete,account_id,tour_id)
VALUES (5,5,'2001-02-11 00:00:00.000000',0,1,1),
(6,6,'2001-02-11 00:00:00.000000',0,2,2),
(7,7,'2001-02-11 00:00:00.000000',0,3,3);
insert into payment (status,booking_id)
values(0,1),(0,2),(0,3);