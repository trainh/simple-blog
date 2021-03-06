USE [SimpleLog]
GO
/****** Object:  Table [dbo].[tbl_Account]    Script Date: 10/3/2021 12:25:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Account](
	[email] [varchar](70) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[password] [varchar](max) NOT NULL,
	[role] [int] NOT NULL,
	[status] [int] NOT NULL,
 CONSTRAINT [PK_tbl_Account] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Article]    Script Date: 10/3/2021 12:25:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Article](
	[articleID] [int] IDENTITY(1,1) NOT NULL,
	[tital] [nvarchar](100) NOT NULL,
	[shortDescription] [nvarchar](500) NOT NULL,
	[author] [nvarchar](50) NULL,
	[date] [date] NOT NULL,
	[contentArticle] [nvarchar](max) NOT NULL,
	[status] [int] NOT NULL,
 CONSTRAINT [PK_tbl_Acticale] PRIMARY KEY CLUSTERED 
(
	[articleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Comment]    Script Date: 10/3/2021 12:25:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Comment](
	[articleID] [int] NOT NULL,
	[email] [varchar](70) NOT NULL,
	[comment] [nvarchar](50) NOT NULL,
	[date] [datetime] NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_Account] ([email], [name], [password], [role], [status]) VALUES (N'trainhse140119@fpt.edu.vn', N'Admin', N'8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 1, 2)
INSERT [dbo].[tbl_Account] ([email], [name], [password], [role], [status]) VALUES (N'traitrantruon@gmail.com', N'Nguyen HoÃ ng Trai', N'8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 2, 2)
GO
SET IDENTITY_INSERT [dbo].[tbl_Article] ON 

INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (1, N'[Nhật kí trường làng: Cày bừa...]', N'Cày đồng đang buổi ban trưa
Mồ hôi thánh thót như mưa ruộng cày
Ai ơi bưng bát cơm đầy
Dẻo thơm một hạt đắng cay muôn phần', N'Hoang Nguyen-The', CAST(N'2021-10-10' AS Date), N'* Bạch thầy, người vừa ngâm thơ?
> Ah, biết hôm nay nhà có quý nhơn ghé, ta hát tặng mày chứ ai!
* Thầy lại thâm nho rồi con rồi!
Bạch thầy, con xin hỏi thầy bí quyết làm sao thầy có thể biến những thứ khô cứng 010101 của lập trình và cơ sở dữ liệu thành những thứ mượt mà nuột nà trơn tuột hơn cả Ngọc Trinh vậy thầy?
> À, ta gọi đó là bí thuật.
* Bạch thầy, thầy vẫn dạy chúng con rằng phải biết chia sẻ, san sẻ điều mình yêu thương.
> Cái thằng, chỉ được cái miệng nhanh hơn não. Tao có nói rằng tao không chỉ cho mày đâu?
* Dạ con mong thầy khai sáng ạ
> Tặng mày 2 khẩu quyết, TBCC và HTH
* Thầy, con vốn nông cạn, trước giờ chỉ biết COCC, con mạo muội đoán TBCC là Thầy Bu Cứu Cánh, và Hope That Helps. Con cái không dựa Cha Mẹ thì dựa ai, đúng hôn thầy?
> Uh, xưa nay mày học lập trình hướng đối tượng vốn chỉ giỏi mỗi khái niệm kế thừa - inheritance, chẳng muốn làm gì cả vì chỉ nghĩ được điều duy nhất là chờ kế thừa di sản từ ông bà bô. Tao nói mày nghe, miệng ăn núi lở đó đó!!!
* Bởi thế con mới đu theo thầy, mong thầy kiên nhẫn
> TBCC là Trâu Bò Cày Cuốc, HTH là Hen...Tai...Hóa
* Con biết thầy giỏi sắp chữ bàn phím, con vẫn giỏng tai nghe đây ạ
> Thì đó, cái ngành IT này vốn dĩ nó đòi hỏi tính cần mẫn chăm chỉ cày bừa như trâu như cờ-hó, học từ cái sai đến cái thất bại để mới có được cái bất bại lợi hại của chuyên môn. Kiến thức ngành này vốn nhiều, và ngày càng chồng chất thêm, Hen...Tai...Hóa chính là cách hệ thống hóa lại kiến thức đang có để còn có thêm không gian lưu trữ trong cái não bộ vốn lộn xộn full-of thứ xàm xí đú của mày.
* Con tưởng thầy cho con được thứ gì vi diệu hay ho?
> Nếu mọi thứ ở mày đang ổn, chắc là mày gặp tao để gáy chứ sao lại đi xin bí thuật làm chi?
* Con lại nông cạn rồi, bạch thầy đã thương thì thương cho trót, người cho con xin cái ví dụ cụ thể để thực hành bí thuật này không ạ?
> Hãy xem YouTube ta bài học nghiêng thùng database đổ nước SQL ngày hôm nay đi kèm đĩa salad đính kèm post này để hiểu cày-bừa & hen...tai...hóa là cái chi chi!!!
https://www.youtube.com/watch?v=u4QhmAk8nyA
* Dạ để con cày viu lĩnh ngộ ạ, cảm tạ bạch thầy!
> Gọi với theo...... Này ku... cày bừa kiếm lúa bỏ miệng đắng cay lắm lắm đó, hỏi tía má coi có đúng hem heng?
HAPPY CODE - HAPPY MONEY - HAPPY LIFE', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (2, N'[Nhật kí trường làng: Không thèm cái dây nịt...]', N'Dịch COVID-19 đã lấy đi của mọi người rất rất nhiều thứ, từ những điều thân thương nhất đến những điều nhỏ nhặt nhất. Mất mát đến độ không thèm cái dây nịt, không cần cái dây nịt luôn, vì quần tây, quần dài đã là thứ đi vào lịch sử.', N'Hoang Nguyen-The', CAST(N'2021-10-10' AS Date), N'Mất mát là thế, nhưng khi vẫn còn WIFI, còn đôi tay, khối óc, con mắt, hơi thở, thì vẫn còn đó cái hy vọng, cái cơ hội, cái quyền được học online, cái quyền được trau dồi tri thức/trí tuệ theo cách của riêng ta, để một khi ""bình-thường-mới-hơn" của cái "bình-thường-mới-đã-cũ" ló rạng, ta quay trở lại vững chãi gấp ngàn xưa.
Stay strong, stay focused vì chúng ta đang có thời gian để tụng niệm và làm điều đó ngay lúc này mỗi ngày. 
HÃY SẴN SÀNG KHI MỌI THỨ SẮP SẴN SÀNG...
Một cung đường url, một điểm đến lớp học online của giáo.làng kì COVID-19 thứ mấy chả thèm đếm nữa...
https://meet.google.com/spi-addt-gsk
Nhà tôi đã ba đời nay yêu vẻ đẹp nghiêng thùng Database đổ nước SQL, nếu muốn tắm mình trong nét đẹp của lưu trữ dữ liệu, mời cả nhà ghé thăm môn học Nhập môn CSDL - DBI202 theo lịch đính kèm hoặc nhấn chuông theo dõi gã Youtuber nhà quê tại https://www.youtube.com/channel/UChsPO5CLUjOWfgwjfC2Y-Wg cho những bài giảng được post lên trong ngày.
HAPPY CODE - HAPPY MONEY - HAPPY LIFE', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (3, N'HỌC CÁCH TẠO BẢN SẮC RIÊNG CỦA BẢN THÂN TRONG MÙA THU NÀY CÙNG VỚI "HỒ SEN CHỜ AI', N'Cùng note lại những thông tin dưới đây và chờ ngày được chia sẻ cùng nhau nào:
🌟 Talkshow Hồ Sen Chờ Ai - "Tôi đấy ư?"
 Thời gian: 19h30 ngày 03/09/2021 (thứ sáu)
 Tham gia talkshow tại link này nha: meet.google.com/fte-ehzr-mrm', N'FPT Around', CAST(N'2021-01-11' AS Date), N'Đôi lúc các bạn có tự cảm thấy bản thân mình lạc lõng giữa những người xung quanh, cảm thấy bản thân mình khác biệt so với tất cả mọi người? Chính điều này làm bạn phải thu mình lại, thay đổi bản thân để có thể hòa nhập được xã hội? Đến với “Hồ Sen Chờ Ai” lần này với chủ đề "Tôi đấy ư?", các bạn có thể học được cách xây dựng bản sắc riêng thật riêng cho bản thân mình. Từ đó mỗi người chúng ta đều có thể tự tin và yêu lấy chính bản thân mình, đừng vì bản thân khác với số đông mà ta phải thu mình trong kén để rồi ngủ đông mãi mãi mà hãy trở thành một chú bướm đầy màu sắc, mạnh mẽ tung đôi cánh bay trên bầu trời xanh. ới bộ ba quen thuộc: cô Chung, cô Thục và thầy Hoàng, các bạn sẽ học được cách xây dựng những điều đặc biệt của riêng bản thân chúng ta và chấp nhận bản sắc riêng của mọi người', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (4, N'[Nhật kí trường làng: Ai rồi cũng khÁC...]', N'Làm nghề giảng dạy việc vui nhiều hơn việc buồn.', N'Hoang Nguyen-The', CAST(N'2021-10-12' AS Date), N'Vui với bài giảng, vui với học trò, vui ké ăn theo sự thành công của học trò, vui vì nhìn thấy tụi nhỏ trưởng thành mỗi ngày. Vui nhiều lắm...
Buồn tuy ít nhưng buồn lắm luôn: có học trò HỌC rất PHÍ, phí thanh xuân, phí tiền tía má. 
Nhưng có cái công việc mà không phải vui hay buồn mà là SỢ. Rất SỢ nhưng thuộc trách nhiệm PHẢI làm. 
NỖI SỢ ÔNG HỘI ĐỒNG...
Phàm nghề nào cũng có cái gọi là "rủi ro nghề nghiệp". Và ranh giới giữa thiên thần và ác quỷ mấy ai dám chắc mình không bao giờ lấn làn?
Chọn nghề giảng dạy bởi giáo muốn đóng vai thiên thần. Và trò chơi số phận bảo rằng giáo phải thêm vai ông hội đồng; và chưa mùa hội đồng nào cho giáo cảm giác đất nước trọn niềm vui!
Giáo thích nhìn nụ cười của trò khi bế mạc hội đồng. Giáo thích nhìn nước mắt của trò vì xúc động trào dâng. Giáo nuốt nước mắt vào lòng khi phải "trảm" những "đứa con" thân yêu mà có dính chút phần "dưỡng" của mình.
Thương lắm, thương thật, đau thật, tâm tư thật...
Có thương giáo, như đã từng thương giáo, đừng bắt giáo rồi phải khÁC, phải khÁC. Tâm trạng lắm đó trò!
Trò nên biết, ngành SE của ĐH FPT.HCM cũng đã hơn cả 10 mùa bánh chưng, và triết lí chấm khóa luận tốt nghiệp đã vào guồng, với tâm thế tìm cơ hội hơn là tìm khuyết điểm; soi cái hay để override cái dở, nâng hơn là đạp!!! Hãy tin giáo ở triết lí này để cùng nhau THẤU CẢM!!!
Các trò có biết không, khóa luận tốt nghiệp là thành tựu quan trọng nhất ở 4 năm đại học đấy, gói trọn 4 năm thanh xuân với đa tầng ý nghĩa bên trong đó. Trò có muốn sản phẩm để đời này là thứ luôn tự hào để đem đi khoe gáy, minh chứng cho sự trưởng thành, là thứ đáng để lưu vĩnh viễn vào Drive cá nhân. Hay trò muốn là thứ mình làm cho xong, sau đó mình không muốn nhìn lại dù chính mình là tác giả? 
Capstone Project mang sẵn ý nghĩa viên đá tảng chốt đỉnh vòm, một kĩ thuật/thành tố quan trọng trong việc xây dựng các kiến trúc thời xưa (giáo đã từng có 1 bài về khái niệm này - lục lại history đi bạn), chuyện hệ trọng cả đời chứ hok đùa!!!
Vẫn biết rằng báo cáo khóa luận tốt nghiệp chẳng ai muốn re-do, thế nên càng phải chỉn chu, trong khả năng mình đang có, được không trò? GO BIG chỉ 1 lần, và GO HOME vẻ vang, được không trò?
Trò có biết, Apple khi thiết kế iPhone, họ còn tính đến cả cái cảm giác cầm hộp, trải nghiệm đập hộp, chuẩn từ cái hộp chuẩn đi dù sau đó có khi mình quăng cái hộp! 
Cái vĩ đại và cái tinh tế nó được tạo bởi từ những thành tố hoàn hảo nhỏ nhất. 
Ta hướng đến sự hoàn hảo (dù có khi là không tưởng) hơn là "vái trời ông Địa" cho các thánh không soi ra cái to chình ình - rủi ro lắm bạn!!!
Hãy cho giáo thấy chút thiếu sót của bạn chỉ là vết trầy để điểm xuyết, để xuýt xoa cho cái thứ hoàn hảo mà bạn tạo ra, thay vì biến gã nhỏ con này trở thành "tiểu nhân mỏ nhọn", được không trò?
Đã đủ bão giông cho mỗi người...
Chúng ta ai rồi cũng sẽ khÁC, chứ không nên ÁC, nhé mọi người!!!
Nhân vô thập toàn, giáo và bạn, ta cùng hoàn thiện những thứ chúng ta đã bày ra, nhé!!!
Trời mưa, ngày bế mạc hội đồng chấm tốt nghiệp style online, tháng ngâu cấm túc, mùa dịch dọc, năm COVID second.
HAPPY CODE - HAPPY MONEY - HAPPY LIFE', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (5, N'BẢO VỆ ĐỒ ÁN THÀNH CÔNG ', N'Cảm ơn vì tất cả ❤', N'Trang Thuỳ', CAST(N'2021-10-13' AS Date), N'Lời đầu tiên, chúng em xin gửi lời cảm ơn chân thành đến thầy Phạm Công Thành và thầy Hoang Nguyen-The đã hỗ trợ chúng em trong suốt thời gian qua.
Cảm ơn các thành viên vì sự nhiệt tình, chăm chỉ và nỗ lực không ngừng. Đôi khi nhóm chúng ta rơi vào trạng thái căng thẳng và mệt mỏi, nhưng chúng ta đã cùng nhau vượt qua :v
Cảm ơn bạn Hồ Thanh Tâm đã bỏ thời gian, công sức tạo ra video giới thiệu cho chúng mình, với giọng đọc truyền cảm.
Cuối cùng, xin cảm ơn gia đình và bạn bè, những người đã ủng hộ tinh thần cho chúng em. ', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (6, N'[Nhật kí trường làng: Xin cho một vé bình yên...]', N'Tối cuối tuần rằm tháng ngâu, đêm chuyển giao tuần cao điểm giãn cách vì COVID-19 ở xứ Sài Thành. Mưa to từ chiều dường như chưa đủ mà còn lây rây đến khuya... Trăng rằm chẳng có dịp ghé, ngẫm nhân tình thế thái, lòng người buồn như trấu cắn!', N'Hoang Nguyen-The', CAST(N'2021-10-15' AS Date), N'Tối cuối tuần rằm tháng ngâu, đêm chuyển giao tuần cao điểm giãn cách vì COVID-19 ở xứ Sài Thành. Mưa to từ chiều dường như chưa đủ mà còn lây rây đến khuya... Trăng rằm chẳng có dịp ghé, ngẫm nhân tình thế thái, lòng người buồn như trấu cắn!
Giáo.làng gia trang thật yên tĩnh. Giáo vẫn cặm cụi đọc và soạn bài chuẩn bị cho những kế hoạch giảng dạy sắp tới.
Bỗng dưng!... Hình như có một cái gì đó đã xảy ra? Có một âm thanh kéo dài lạ lùng làm sao. Giáo làng thầm nghĩ: “Không thể nào là ánh trăng rằm tròn vành vạnh bị mưa lạnh quăng quật, tan vỡ ra, đập vào cửa sổ… vì trời mưa từ hồi chiều đến khuya kia mà. Trăng thanh vốn phải luôn đi với gió mát tạnh ráo kia mà!”.
Giáo đứng dậy tìm kiếm. Và đây… Đúng là có một chú dế với "cây vĩ cầm" của mình trốn mưa ngâu lạnh chui vào phòng khách, núp sau cái tivi non-smart. Dế kéo đàn hay đến nỗi giáo.làng phải lấy ngay cái smartphone cũ mèm từ lúc mua cũng chưa dám được xếp hạng trung bình nói chi flagship, quay ngay một video không trăng không sao không đèn chỉ trọn vẹn thứ âm thanh đầy tĩnh tại, và giáo.làng không nén nổi đến mức phải kêu lên:
− Chao ôi, hay quá, thật là tuyệt diệu! Ta phải post video màu nhạc thiền này lên ngay YouTube mới được. 
(Phỏng theo Tập đọc lớp 3 thời giáo.làng còn để chỏm)
22.8.2021 23:57 - một ngày lịch sử mùa COVID
Canh khuya, lặng nghe tiếng thiên nhiên, lòng tìm chút bình yên, chút hy vọng để bình tĩnh nghênh đón tính bất định hỗn mang của tương lai.
*PS1: Này mưa ngâu, mày chỉ nên vừa đủ để làm vơi đi cái hầm hập ngoài kia, nơi tuyến đầu chống dịch, nếu gột rửa được cái con virus kia xuống hầm gas đi thì càng tốt, đừng nhây như con virus kia, ai nấy "bết" lắm rồi.
*PS2: 2 trang sách giáo.làng lồng trong video chụp từ cuốn sách lớp 3 thời giáo để chỏm học đó, là 1 ấn bản in lại sau này nhưng nội dung đúng là của sách ngày xưa, rất may người hoài cổ như giáo đã kịp giữ lại 1 bản yêu thương trong tủ sách. Trong 1 bài giảng thiền giáo từng có duyên nghe, có đoạn giảng rằng, hãy nhìn vào những thứ thương yêu, mỗi ngày, mỗi ngày, sẽ giúp hồn bạn an yên, tĩnh lặng, minh triết. Và lắng nghe tiếng thiên nhiên ngay bên ngoài cửa nhà bạn cũng là một cách hoàn hảo khác giúp duy trì sự quân bình trong bạn.
Chúc cả nhà bình an trong tiếng yêu thương!!!', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (7, N'[Nhật kí trường làng: 360 độ yêu...]', N'Thuở bé giáo.làng đã biết tym mình thuộc hệ đa cảm khối C. Giáo.làng rất dễ rung cảm bởi những vần thơ hay, những lời văn đẹp. Mà chẳng hiểu sách giáo khoa ngày ấy sao mà nhiều áng thơ say lòng người đến vậy? Do người tuyển bài vào sách tinh tế, hay tym mình ưa lỗi nhịp? Và vì lỗi nhịp với ngôn ngữ, mà giáo đã chọn ngành...IT', N'Hoang Nguyen-The', CAST(N'2021-10-16' AS Date), N'Thuở bé giáo.làng đã biết tym mình thuộc hệ đa cảm khối C. Giáo.làng rất dễ rung cảm bởi những vần thơ hay, những lời văn đẹp. Mà chẳng hiểu sách giáo khoa ngày ấy sao mà nhiều áng thơ say lòng người đến vậy? Do người tuyển bài vào sách tinh tế, hay tym mình ưa lỗi nhịp? Và vì lỗi nhịp với ngôn ngữ, mà giáo đã chọn ngành...IT
Ta biết yêu qua những gì được gõ từ bàn phím cổ lỗ hay từ những ngòi bút tài hoa...
Nào là: Thuở còn thơ ngày hai buổi đến trường/Yêu quê hương qua từng trang sách nhỏ (Giang Nam).
Rồi nữa: Tâm hồn tôi là một buổi trưa hè/Toả nắng xuống lòng sông lấp loáng (Tế Hanh).
Nào đã hết: Khi ta lớn lên Đất Nước đã có rồi/Đất Nước có trong những cái “ngày xửa ngày xưa...” mẹ thường hay kể (Nguyễn Khoa Điềm)
Và đỉnh điểm của sự nghêu ngao trong tâm hồn giáo với bài thơ được phổ nhạc của nhà thơ Thanh Hải (NS Trần Hoàn phổ nhạc), bài hát Mùa xuân nho nhỏ, hát cho mùa xuân nghe ở mùa hạ nhưng khi lòng ta biết yêu, thì bốn mùa chỉ còn lại một MÙA YÊU THƯƠNG.
Mọc giữa dòng sông xanh
Một bông hoa tím biếc
Ơi con chim chiền chiện
Hót chi mà vang trời
Từng giọt long lanh rơi
Tôi đưa tay hứng về.
...
Ta làm con chim hót
Ta làm một nhành hoa
Một nốt trầm xao xuyến
Tan biến trong hoà ca.
...
Cuộc sống vốn bộn bề, cạnh tranh, bất an, bất định, cơm-áo-gạo-tiền đã đủ khiến mỗi chúng ta dễ rơi vào trạng thái trầm cảm tuyệt vọng. Ta còn lại gì ngoài những biến động dữ dội ngoài kia nhỉ? Có phải là trái tim và khối óc "mong manh" đang sẵn chực gục đổ nếu ta chẳng làm gì, hay là trong lúc khó khăn nhất đó là lúc con tim khối óc nở hoa?
Hãy cùng giáo.làng đến với buổi livestream "chat-bên-hồ-sen" để cùng nạp lại vi-ta-min tình yêu, để ta thêm yêu đời, yêu người, yêu nghề, thêm yêu cuộc sống mong manh này nhưng vẫn đáng để sống hay là làm cho nó đáng để sống theo cách, theo tiện nghi, khả năng của mỗi người.
...
Một mùa xuân nho nhỏ
Lặng lẽ dâng cho đời
Dù là tuổi hai mươi
Dù là khi tóc bạc.
...', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (8, N'[Nhật kí trường làng: Ngày hôm nay ta họp mặt...]', N'Về giảng dạy tại ĐH FPT, giáo.làng có duyên may được ăn 2 cái sinh nhật bự chảng chà bá lửa: sinh nhật 30 năm tập đoàn FPT (đã) và sinh nhật 15 năm ĐH FPT (đang, sắp).', N'Hoang Nguyen-The', CAST(N'2021-10-17' AS Date), N'Về giảng dạy tại ĐH FPT, giáo.làng có duyên may được ăn 2 cái sinh nhật bự chảng chà bá lửa: sinh nhật 30 năm tập đoàn FPT (đã) và sinh nhật 15 năm ĐH FPT (đang, sắp).
Được mời dự tiệc, được mời góp cỗ, thì một "lời nói hay" về chủ tiệc là điều phù hợp đạo lí chẳng phải bàn cãi. 
Mình sẽ nói gì trong đêm nay? Tiệc tùng thì chắc chắn phải nói chuyện vui, chuyện thành tựu, và mơ về tương lai tươi sáng...
Nhưng lại trộm nghĩ về... 
Sinh viên trường F chúng tôi hay có câu nói vui: Cấm người ngoài "chửi" trường F chúng tao, trường tao chỉ tao mới có quyền "chửi yêu", cười mếu!!!
Này các trò cưng, nhân vô thập toàn, hãy yêu trường F như các bạn đã yêu giáo.làng bấy lâu. Vì ở trường F có thanh xuân của bạn, của tui, có giọt mồ hôi rơi, có nụ cười rạng rỡ, có nước mắt buồn và vui, của cả trò và thầy. 
Yêu để vượt qua trở ngại, để biết có thể tha thứ điều gì, yêu để cùng làm cho mọi thứ tốt hơn mỗi ngày. Và yêu vì những thứ tốt đẹp làm cho ta tốt đẹp hơn.!
Một, hai, ba ta cùng thổi tắt nến
Happy birthday, happy birthday to FU...
Hẹn gặp cả nhà tối nay tại TALKSHOW # 2: NGÔI TRƯỜNG KHÔNG XÂY BỤC GIẢNG để hiểu thêm chuyện nhà F trước khi tiếp tục "chửi yêu" trường:', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (9, N'NHƯNG BÍ MẬT SẼ ĐƯỢC BẬT MÍ TRONG TỐI NAY !', N'FPTU Cần Thơ có gì ngoài gạo trắng nước trong mà rất nhiều cán bộ kệ vợ, kệ con, bỏ Hà Nội vào đó. Là ai thì mình ko tiện nhắc tên (Quang Vu Tran)', N'Lại Hồng Anh', CAST(N'2021-10-21' AS Date), N'FPTU Cần Thơ có gì ngoài gạo trắng nước trong mà rất nhiều cán bộ kệ vợ, kệ con, bỏ Hà Nội vào đó. Là ai thì mình ko tiện nhắc tên (Quang Vu Tran)
 🥰 Liệu rằng có quota thi trượt trong mỗi đợt  final exam của sinh viên FU ?
 🥰 Nhà trường có thực sự chấm lại bài thi khi sinh viên làm đơn phúc khảo ?
 🥰  Trách nhiệm thuộc về ai mỗi khi sinh viên học lại: Đào tạo, thầy cô giảng viên hay . . . Khảo thí ?
Và đằng sau đó, để có được 1 bài giảng, 1 chương trình cho sinh viên học thì các thầy cô, anh chị của đào tạo, khảo thí, ban phát triển chương trình đã phải làm những gì ?
Tất cả sẽ được bật mí trong tối nay nha quí zị
Lần đầu được làm MC truyền hình, anh em tối giả vờ vào khen mình cái nhé !', 2)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (10, N'[Nhật kí trường làng: Học để...]', N'Mùa COVID mong mãi mà chưa hết nhưng mùa tựu trường lại sắp về. Bạn có chút ngần ngại nào cho việc học như chú mèo con trong bài thơ tiểu học này không?', N'Hoang Nguyen-The', CAST(N'2021-10-22' AS Date), N'Mùa COVID mong mãi mà chưa hết nhưng mùa tựu trường lại sắp về. Bạn có chút ngần ngại nào cho việc học như chú mèo con trong bài thơ tiểu học này không?
Mèo con buồn bực
Mai phải đến trường
Bèn kiếm cớ luôn:
- Cái đuôi tôi ốm
Cừu mới be toáng:
- Tôi sẽ chữa lành
  Nhưng muốn cho nhanh
  Cắt đuôi khỏi hết!
- Cắt đuôi? Ấy chết...!
Tôi đi học thôi! (Theo P.Vô-rôn-cô)
Có ăn học tử tế chưa chắc đã giàu có thành công, nhưng vì một lí do nào đó không theo đuổi được sự học thì chắc chắn rằng công cuộc mưu sinh sẽ bội phần vất vả lam lũ. Giáo tin như thế!!!
Sự thành công vượt bậc chắc không dành cho số đông nhưng trong đó luôn bao hàm sự học, học theo mọi hoàn cảnh & hình thức.
Bạn đã sẵn sàng dung dưỡng cho sự lười học của mình với vô vàn lí do trì hoãn ngày này sang tháng khác, nhưng bạn chẳng thể chịu được lâu cơn đói giày vò khi bỏ một bữa hay thiếu một bữa. Thiếu tiền, đói ăn thì chẳng nói chuyện ăn chơi!
Bạn dành thời gian cả ngày để làm những điều vô vị, để mơ mộng viển vông, để sống ảo trong đời thật nhưng lại chẳng tự giác dành phút nào cho việc học để thành công, học để có sự tươm tất của cơm ăn áo mặc. Thực tế đi bạn!
Học, tìm tòi tri thức, tìm lối đi thành công nó tựa trò chơi cút bắt trốn tìm. Bạn có tìm mà chưa chắc đã thấy; đừng mơ mộng rằng bạn ở đó "do nothing" và nó tự tìm đến bạn - chuyện hoang đường!
👉 NẾU biết rằng lúc này mình vẫn chưa có thể giúp gì cho ba má khi ba má đang ngập trong những lo toan trong thời bình thường, thêm vạn thứ lo toan trong thời dịch dọc giãn cách... 
📌 THÌ hãy làm cái việc mà giáo tin rằng bạn có thể làm tốt nhất (cũng ngay lúc này), trong khả năng, vừa tầm sức của bạn: HỌC, HỌC MỌI THỨ CÓ THỂ TRONG MỌI HOÀN CẢNH CÓ THỂ. Học để tự tạo ra cánh cửa cơ hội cho mình, hay học để ai đó tìm đến bạn gõ cửa trao cho cơ hội. 
Học để kiếm nhiều tiền một cách chân chính đặng giúp mình và những người xung quanh có được hạnh phúc.
✅ Gửi bạn chút động lực trong mùa tựu trường mới sắp gần kề, video Quán đầu làng: https://www.youtube.com/watch?v=Amk7czbhhYk...
Mến chúc bạn bè thân hữu gần xa sức khỏe, vạn sự an lành trong mùa COVID
✅ Lời cảm ơn cho video Quán đầu làng
* Cảm ơn Ban tổ chức TEDxFPTUniversityHCMC, CLB Skillcetera đã mang đến những giá trị hữu ích cho cộng đồng.
* Đặc biệt cảm ơn các bạn Trần Nguyễn Phước, Huỳnh Hương, MC Tuấn Khải và ê-kíp đã cho giáo.làng cơ hội chia sẻ suy nghĩ của mình.
* Đặc biệt cảm ơn các thế hệ sinh viên đã yêu quý và ủng hộ giáo.làng
Các bạn mãi là niềm cảm hứng bất tận cho ngọn lửa nhiệt huyết trong giáo.làng luôn luôn bùng cháy!', 5)
INSERT [dbo].[tbl_Article] ([articleID], [tital], [shortDescription], [author], [date], [contentArticle], [status]) VALUES (11, N'[Nhật kí trường làng: Chuyên gia đọc lệnh...]', N'Đang ngồi làm việc, FB Messenger bật lên cuộc gọi video từ một nhóm trai xinh gái đẹp chuẩn rich-kid tài chính 4.0.', N'traitrantruon@gmail.com', CAST(N'2021-09-30' AS Date), N'Đang ngồi làm việc, FB Messenger bật lên cuộc gọi video từ một nhóm trai xinh gái đẹp chuẩn rich-kid tài chính 4.0.
"Chúng em đến từ sàn săn tiền thưởng conFti, nơi đem đến cơ hội tiền triệu cho mọi sinh viên của thầy sau 8 giờ tối mỗi thứ 7, thầy nghĩ sao ạ?"
"Thầy cứ yên tâm, tham gia sàn này chỉ từ được đến được, trò của thầy chỉ việc đọc lệnh trong 20s là có tiền ào vô cái ví MoMo"
???
"Các trò của thầy sẽ có cơ hội gia tăng tài sản từ 0 đồng đến 1.5 triệu đồng đầu tiên chỉ sau những màn đọc câu hỏi và nhấn nút lệnh"
!!!
"Đã đến lúc thầy phải tin rằng học trò của thầy ai cũng là những chuyên gia nổ lệnh chứ. Thầy mà còn chán nản thiếu niềm tin thì làm sao mà học trò thầy có động lực cho được!"
?!?
"À, ờ, vậy tao phải làm gì?" 
"Chẳng gì nhiều nhặn đâu thầy. Thầy chỉ giúp chúng em với vai trò chuyên gia dò quiz tại nhà, cắt tỉa câu hỏi và hô hào các tình yêu ghé thăm vườn hồng tụi em là được rồi"
"...Tưởng gì, chuyên gia tỉa câu hỏi là nghề của tao, để tao"
Hỡi các tình yêu, hỡi các trò F thân yêu, bỏ 20s kiếm tí tiền triệu không chút rủi ro đã không còn là chuyện huyền thoại đâu nhé. Tại bạn lười thôi chứ ai giờ cũng chăm chỉ hết cả rồi, thật đấy.
Hãy vào link sau để không bất ngờ khi chỉ cần 20s đã có thể hô biến bạn thành chuyên gia huyền thoại đọc quiz tại nhà, kẻ nắm giữ bí quyết nhấn nút CÓ THỂ ra tiền, làm giàu cũng khó và hắc não ra phết!', 1)
SET IDENTITY_INSERT [dbo].[tbl_Article] OFF
GO
INSERT [dbo].[tbl_Comment] ([articleID], [email], [comment], [date]) VALUES (10, N'traitrantruon@gmail.com', N'Hay quá ạ!!!', CAST(N'2021-09-27T00:00:00.000' AS DateTime))
INSERT [dbo].[tbl_Comment] ([articleID], [email], [comment], [date]) VALUES (10, N'traitrantruon@gmail.com', N'Bài Bog hay quá!', CAST(N'2021-09-29T13:49:06.887' AS DateTime))
INSERT [dbo].[tbl_Comment] ([articleID], [email], [comment], [date]) VALUES (10, N'traitrantruon@gmail.com', N'Bài Bog hay quá!', CAST(N'2021-09-29T13:49:59.893' AS DateTime))
INSERT [dbo].[tbl_Comment] ([articleID], [email], [comment], [date]) VALUES (10, N'traitrantruon@gmail.com', N'Bài Bog hay quá!', CAST(N'2021-09-29T13:50:51.167' AS DateTime))
INSERT [dbo].[tbl_Comment] ([articleID], [email], [comment], [date]) VALUES (10, N'traitrantruon@gmail.com', N'Bài Bog hay quá!', CAST(N'2021-09-29T13:55:16.633' AS DateTime))
GO
ALTER TABLE [dbo].[tbl_Comment]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_Comment_tbl_Account] FOREIGN KEY([email])
REFERENCES [dbo].[tbl_Account] ([email])
GO
ALTER TABLE [dbo].[tbl_Comment] CHECK CONSTRAINT [FK_Tbl_Comment_tbl_Account]
GO
ALTER TABLE [dbo].[tbl_Comment]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_Comment_tbl_Article] FOREIGN KEY([articleID])
REFERENCES [dbo].[tbl_Article] ([articleID])
GO
ALTER TABLE [dbo].[tbl_Comment] CHECK CONSTRAINT [FK_Tbl_Comment_tbl_Article]
GO
