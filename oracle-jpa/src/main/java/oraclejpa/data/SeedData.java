package oraclejpa.data;

import oraclejpa.entity.Category;
import oraclejpa.entity.Product;
import oraclejpa.repository.ICategoryRepository;
import oraclejpa.repository.IProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SeedData {

    private final ICategoryRepository categoryRepository;
    private final IProductRepository productRepository;

    @PostConstruct
    private void init(){
        initCategory();
        initProduct();
    }

    private void initCategory(){
        if (categoryRepository.count() != 0)
            return;

        List<Category> categories = new ArrayList<>();
        String[] categoryNames = {
            "Quần áo", "Giày dép", "Túi xách", "Phụ kiện", "Điện thoại",
            "Laptop", "Máy tính bảng", "Tai nghe", "Camera", "Đồng hồ",
            "Trang sức", "Mỹ phẩm", "Sách", "Đồ chơi", "Đồ ăn",
            "Đồ uống", "Thiết bị gia dụng", "Nội thất", "Thể thao", "Công cụ"
        };

        String[] categoryDescriptions = {
            "Áo, quần, váy, tất và các loại quần áo khác",
            "Giày thể thao, dép, sandal, giày lười",
            "Túi xách, balo, ví, porte",
            "Vòng tay, dây chuyền, khăn, mũ, kính",
            "Điện thoại di động và phụ kiện",
            "Laptop, máy tính xách tay",
            "Ipad, tablet và các thiết bị di động",
            "Tai nghe, loa Bluetooth, micro",
            "Camera DSLR, mirrorless, action camera",
            "Đồng hồ đeo tay thời trang",
            "Vòng tay, dây chuyền, nhẫn, bông tai",
            "Mỹ phẩm, kem dưỡng da, nước hoa",
            "Sách, truyện, tài liệu học tập",
            "Đồ chơi trẻ em, mô hình, lego",
            "Bánh, kẹo, chocolate, snack",
            "Nước giải khát, cà phê, trà, sữa",
            "Tủ lạnh, máy giặt, lò vi sóng",
            "Ghế, bàn, tủ, giường",
            "Quần áo thể thao, giày chạy bộ, dụng cụ",
            "Cưa, búa, máy khoan, dụng cụ xây dựng"
        };

        for (int i = 0; i < 20; i++) {
            categories.add(new Category(null, categoryNames[i], categoryDescriptions[i], null));
        }

        categoryRepository.saveAll(categories);
    }

    private void initProduct(){
        if (productRepository.count() != 0)
            return;

        List<Product> products = new ArrayList<>();

        String[][] productNames = {
            // Quần áo
            {"Áo phông trắng", "Áo phông đen", "Áo phông xanh", "Áo sơ mi trắng", "Áo sơ mi xanh", "Quần tây đen", "Quần tây xám", "Quần jean xanh", "Quần jean đen", "Áo hoodie", "Áo khoác denim", "Váy chữ A", "Váy midi", "Quần legging", "Tất cotton", "Áo tank top", "Áo cardigan", "Quần short", "Áo len", "Áo giản đơn"},
            // Giày dép
            {"Giày Nike", "Giày Adidas", "Giày Puma", "Giày Converse", "Giày Vans", "Dép Crocs", "Sandal Teva", "Giày Oxford", "Giày Chelsea", "Giày thế thao", "Dép kẹp", "Giày lười", "Giày boot", "Giày thể thao trắng", "Giày canvas", "Dép quai hậu", "Sandal bảng", "Giày công sở", "Giày lập pogram", "Dép đi trong nhà"},
            // Túi xách
            {"Balo laptop", "Túi xách tay", "Túi vai", "Ví da", "Túi du lịch", "Porte tiền", "Túi vải", "Balo du khách", "Túi đựng điện thoại", "Túi cosmetic", "Balo học sinh", "Túi đeo chéo", "Ví cầm tay", "Túi khóa", "Balo thể thao", "Túi tote", "Porte khoá", "Túi chứa đồ", "Túi bao tử", "Balo nylon"},
            // Phụ kiện
            {"Dây chuyền vàng", "Dây chuyền bạc", "Vòng tay da", "Vòng tay cườm", "Khăn lụa", "Mũ beret", "Kính mát", "Thắt lưng", "Khăn quàng cổ", "Nón bảo hiểm", "Bông tai",  "Nhẫn vàng", "Nhẫn bạc", "Kẹp tóc", "Nơ tóc", "Vớ giả da", "Cà vạt", "Túi dây rút", "Bao tay", "Khăn trải bàn"},
            // Điện thoại
            {"iPhone 15 Pro", "Samsung Galaxy S24", "Xiaomi 14", "OnePlus 12", "Google Pixel 8", "iPhone 14", "Samsung A54", "Xiaomi Redmi", "Oppo A96", "Vivo V27", "iPhone SE", "Samsung Z Fold", "Motorola G84", "Realme 12", "Infinix Note", "Tecno Spark", "Nothing Phone", "Honor 90", "Poco X6", "iQOO 12"},
            // Laptop
            {"MacBook Pro M3", "Dell XPS 13", "HP Pavilion", "Lenovo ThinkPad", "ASUS VivoBook", "Acer Aspire", "MSI GS66", "Razer Blade", "LG Gram", "Surface Laptop", "MacBook Air", "Dell G15", "HP Envy", "ASUS ROG", "Lenovo Legion", "Acer Swift", "MSI Prestige", "Razer Book", "LG UltraBook", "HP Spectre"},
            // Máy tính bảng
            {"iPad Pro 12.9", "iPad Air", "iPad Mini", "Samsung Tab S9", "Lenovo Tab P12", "Xiaomi Pad 6", "OnePlus Pad", "Microsoft Surface", "Amazon Fire", "iPad 10.9", "Galaxy Tab A", "Lenovo M11", "ASUS ZenPad", "Nokia Tab", "Apple iPad", "Samsung Tab S6", "Huawei MatePad", "realme Pad", "Poco Pad", "TCL Tab"},
            // Tai nghe
            {"AirPods Pro", "Sony WH-1000XM5", "Bose QuietComfort", "Sennheiser Momentum", "JBL Tune", "Beats Solo", "Anker Soundcore", "LDAC Hi-Res", "Marshall Major", "Audio-Technica", "Jaybird Vista", "Bang & Olufsen", "Skullcandy Crusher", "Turtle Beach", "SteelSeries Arctis", "HyperX Cloud", "Plantronics BackBeat", "Jabra Elite", "Samsung Galaxy Buds", "Google Pixel Buds"},
            // Camera
            {"Canon R5", "Nikon Z9", "Sony A7IV", "Panasonic S1", "Leica M11", "Fujifilm X-H2", "OM System S1", "Pentax K-3III", "Canon R6", "Nikon Z6III", "Sony A6700", "GoPro Hero12", "DJI Osmo", "Insta360 ONE", "Ricoh Theta", "OnePlus 11T Ultra", "Xiaomi 13 Ultra", "Samsung S24 Ultra", "iPhone 15 Pro Max", "Google Pixel 8 Pro"},
            // Đồng hồ
            {"Apple Watch Ultra", "Samsung Galaxy Watch", "Garmin Fenix", "Fossil Gen 6", "Seiko SKX", "Omega Seamaster", "Rolex Submariner", "Cartier Ballon", "Tag Heuer Aquaracer", "Patek Philippe", "Hublot Big Bang", "Breitling Navitimer", "Tudor Black Bay", "Longines HydroConquest", "Tissot PRX", "Citizen Promaster", "Orient Mako", "Timex Weekender", "Swatch Sistem", "G-Shock DW"},
            // Trang sức
            {"Nhẫn kim cương", "Nhẫn vàng 24k", "Nhẫn bạc 925", "Dây chuyền vàng", "Dây chuyền bạc", "Bông tai kim cương", "Vòng tay ngọc", "Dây chuyền ngọc", "Nhẫn đá quý", "Vòng tay vàng", "Lắc tay bạc", "Bông tai vàng", "Bông tai bạc", "Chân váy vàng", "Chân váy bạc", "Bộ trang sức cưới", "Nhẫn cươi", "Vòng cổ công chúa", "Mặt dây chuyền", "Kẹp tóc ngọc"},
            // Mỹ phẩm
            {"Foundation MAC", "Kem nền Estée Lauder", "Mascara Maybelline", "Phấn phủ Clinique", "Kem dưỡng Olay", "Serum Vichy", "Nước hoa Chanel", "Kem chống nắng Sunplay", "Toner Nudie Jeans", "Mặt nạ sheet", "Son môi Revlon", "Che khuyết điểm Concealer", "Phấn má hồng", "Mắt xanh Eyeliner", "Tẩy trang Micellar", "Kem ủ dưỡng", "Mặt nạ mật ong", "Dầu duỡng tóc Argan", "Sữa rửa mặt", "Kem làm trắng"},
            // Sách
            {"Nhà giả kim", "Chiến tranh và hòa bình", "1984", "Những người thay đổi thế giới", "Tư duy nhanh tính chậm", "Bố bạn giàu bố tôi nghèo", "Kỹ năng giao tiếp", "Lối sống Nhật Bản", "Sáng tạo không có giới hạn", "Nếu như tôi có 48 giờ", "Sức mạnh của thói quen", "Người thông minh rồi sao", "Điều kỳ diệu không tự nhiên", "Thắng mặc nhân loại", "Tuân thủ quy luật vũ trụ", "Khoa học rất thú vị", "Lịch sử loài người", "Triết học cơ bản", "Tâm lý học ứng dụng", "Kỹ năng quản lý thời gian"},
            // Đồ chơi
            {"Lego City", "Lego Star Wars", "Lego Ninjago", "Rubik 3x3", "Rubik Megaminx", "Máy bay điều khiển", "Xe RC", "Robot lập trình", "Mô hình Pokemon", "Mô hình Gundam", "Búp bê Barbie", "Búp bê LOL", "Trò chơi cờ", "Trò chơi bài", "Công viên giải trí", "Mô phỏng thế giới", "Thú nhồi bông", "Puzzle 1000 mảnh", "Game board Monopoly", "Lego Architecture"},
            // Đồ ăn
            {"Bánh Oreo", "Bánh Sunmilk", "Bánh quy Danisa", "Chocolate Ferrero", "Socola Lindt", "Kẹo Haribo", "Kẹo Skittles", "Bánh mì sandwich", "Bánh mì Pháp", "Bánh ngọt tiramisu", "Bánh sponge", "Bánh cheesecake", "Bánh macarons", "Bánh donut", "Bánh crepe", "Bánh croissant", "Bánh bran muffin", "Đồ chua muối", "Thịt khô", "Cá khô"},
            // Đồ uống
            {"Cà phê espresso", "Cà phê lạnh", "Trà xanh Nhật", "Trà đen", "Trà ô long", "Nước trái cây tươi", "Nước cam ép", "Sữa tươi", "Sữa chua", "Sữa đậu nành", "Nước lọc", "Nước khoáng", "Nước tương bắp", "Nước cốt nhạc hạ", "Rượu vang", "Rượu whiskey", "Bia Heineken", "Bia Tiger", "Bia Sapporo", "Rượu vodka"},
            // Thiết bị gia dụng
            {"Tủ lạnh LG", "Tủ lạnh Samsung", "Máy giặt LG", "Máy giặt Samsung", "Máy rửa chén", "Lò vi sóng", "Nồi cơm điện", "Bếp từ", "Máy hút mùi", "Máy sấy quần áo", "Quạt điều hòa", "Máy sưởi", "Máy thổi khí nóng", "Đèn LED", "Tivi Samsung", "Tivi Sony", "Dàn âm thanh", "Máy khiêu vũ", "Máy massage", "Máy làm sạch"},
            // Nội thất
            {"Ghế sofa", "Ghế da", "Bàn ăn gỗ", "Tủ quần áo", "Giường ngủ", "Nệm cao su", "Nệm lò xo", "Bàn làm việc", "Ghế xoay", "Bàn trà", "Kệ sách", "Tủ rượu", "Bàn bar", "Ghế bar", "Khung giường", "Chân ghế", "Tay vịn sofa", "Đệm ghế", "Gối tựa lưng", "Rèm cửa"},
            // Thể thao
            {"Quần áo thể thao Nike", "Quần áo Adidas", "Giày chạy bộ", "Dụng cụ yoga", "Vòng lưng tập", "Tạ miếng", "Tạ đơn", "Thanh xà phòng", "Bao cát", "Găng tay boxing", "Bóng bàn", "Vợt tennis", "Vợt cầu lông", "Bóng chuyền", "Bóng rổ", "Bóng đá", "Ván trượt", "Xe đạp", "Mũ bảo hiểm", "Đai bảo vệ"},
            // Công cụ
            {"Cưa chand", "Búa cộc", "Tua vít", "Tua vít đa năng", "Kìm cắt", "Kìm nhọn", "Khoan tay", "Máy khoan", "Máy khoan vít", "Cấp nước", "Thước cuộn", "Thước kẻ", "Mắt cân", "Dao rọc", "Dao cắt", "Quanh qua dây", "Dây điện", "Bóng đèn", "Ổ cắm", "Công tắc"}
        };

        double[] basePrices = {50, 150, 80, 20, 500, 800, 300, 200, 1500, 300, 2000, 150, 30, 50, 100, 800, 100, 80, 200, 50};

        for (int catId = 1; catId <= 20; catId++) {
            int productCount = 15 + (int)(Math.random() * 6); // 15-20 products
            for (int i = 0; i < productCount; i++) {
                String productName = productNames[catId - 1][i % productNames[catId - 1].length];
                double price = basePrices[catId - 1] + (Math.random() * 50);
                long quantity = 10 + (long)(Math.random() * 90);
                String description = "Sản phẩm " + productName + " - chất lượng cao, giá tốt";

                products.add(new Product(
                    null,
                    productName,
                    Math.round(price * 100.0) / 100.0,
                    quantity,
                    description,
                    new Category((long) catId)
                ));
            }
        }

        productRepository.saveAll(products);
    }
}
