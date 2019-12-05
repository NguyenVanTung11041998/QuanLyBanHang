import Corba_DAO.*;
import DAO.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {
    static AccountAdminDAO accountAdminDAO;
    static NhaCungCapDAO nhaCungCapDAO;
    static NhaSanXuatDAO nhaSanXuatDAO;
    static KhachHangDAO khachHangDAO;
    static HoaDonChiTietDAO hoaDonChiTietDAO;
    static HoaDonDAO hoaDonDAO;
    static PhieuNhapDAO phieuNhapDAO;
    static PhieuNhapChiTietDAO phieuNhapChiTietDAO;
    static GioHangDAO gioHangDAO;
    static SanPhamDAO sanPhamDAO;
    static DanhMucDAO danhMucDAO;
    static LoaiSanPhamDAO loaiSanPhamDAO;
    
    public static void main(String args[]) {

        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name = "IAccountAdmin";
            accountAdminDAO = (AccountAdminDAO) IAccountAdminDAOHelper.narrow(ncRef.resolve_str(name));
            name = "INhaSanXuat";
            nhaSanXuatDAO = (NhaSanXuatDAO) INhaSanXuatDAOHelper.narrow(ncRef.resolve_str(name));
            name = "INhaCungCap";
            nhaCungCapDAO = (NhaCungCapDAO) INhaCungCapDAOHelper.narrow(ncRef.resolve_str(name));
            name = "ISanPham";
            sanPhamDAO = (SanPhamDAO) ISanPhamDAOHelper.narrow(ncRef.resolve_str(name));
            name = "IKhachHang";
            khachHangDAO = (KhachHangDAO) IKhachHangDAOHelper.narrow(ncRef.resolve_str(name));
            name = "IHoaDonChiTiet";
            hoaDonChiTietDAO = (HoaDonChiTietDAO) IHoaDonChiTietDAOHelper.narrow(ncRef.resolve_str(name));
            name = "IHoaDon";
            hoaDonDAO = (HoaDonDAO) IHoaDonDAOHelper.narrow(ncRef.resolve_str(name));
            name = "IPhieuNhap";
            phieuNhapDAO = (PhieuNhapDAO) IPhieuNhapDAOHelper.narrow(ncRef.resolve_str(name));
            name = "IPhieuNhapChiTiet";
            phieuNhapChiTietDAO = (PhieuNhapChiTietDAO) IPhieuNhapChiTietDAOHelper.narrow(ncRef.resolve_str(name));
            name = "IGioHang";
            gioHangDAO = (GioHangDAO) IGioHangDAOHelper.narrow(ncRef.resolve_str(name));
            name = "IDanhMuc";
            danhMucDAO = (DanhMucDAO) IDanhMucDAOHelper.narrow(ncRef.resolve_str(name));
            name = "ILoaiSanPham";
            loaiSanPhamDAO = (LoaiSanPhamDAO) ILoaiSanPhamDAOHelper.narrow(ncRef.resolve_str(name));
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}
