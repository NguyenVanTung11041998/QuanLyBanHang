import Corba_DAO.*;
import DAO.*;
import DTO.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
    public static void main(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            AccountAdminDAO accountImpl = new AccountAdminDAO();
            accountImpl.setOrb(orb);
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(accountImpl);
            IAccountAdminDAO href = IAccountAdminDAOHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name = "IAccountAdmin";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);
            
            NhaSanXuatDAO nhaSanXuatDAO = new NhaSanXuatDAO();
            nhaSanXuatDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(nhaSanXuatDAO);
            INhaSanXuatDAO href1 = INhaSanXuatDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "INhaSanXuat";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href1);
            
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
            nhaCungCapDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(nhaCungCapDAO);
            INhaCungCapDAO href2 = INhaCungCapDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "INhaCungCap";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href2);
            
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            sanPhamDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(sanPhamDAO);
            ISanPhamDAO href3 = ISanPhamDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "ISanPham";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href3);
            
            PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
            phieuNhapDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(phieuNhapDAO);
            IPhieuNhapDAO href4 = IPhieuNhapDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "IPhieuNhap";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href4);
            
            PhieuNhapChiTietDAO phieuNhapChiTietDAO = new PhieuNhapChiTietDAO();
            sanPhamDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(phieuNhapChiTietDAO);
            IPhieuNhapChiTietDAO href5 = IPhieuNhapChiTietDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "IPhieuNhapChiTiet";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href5);
            
            HoaDonChiTietDAO hoaDonChiTietDAO = new HoaDonChiTietDAO();
            hoaDonChiTietDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(hoaDonChiTietDAO);
            IHoaDonChiTietDAO href6 = IHoaDonChiTietDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "IHoaDonChiTiet";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href6);
            
            HoaDonDAO hoaDonDAO = new HoaDonDAO();
            hoaDonDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(hoaDonDAO);
            IHoaDonDAO href7 = IHoaDonDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "IHoaDon";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href7);
            
            KhachHangDAO khachHangDAO = new KhachHangDAO();
            khachHangDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(khachHangDAO);
            IKhachHangDAO href8 = IKhachHangDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "IKhachHang";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href8);
            
            GioHangDAO gioHangDAO = new GioHangDAO();
            gioHangDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(gioHangDAO);
            IGioHangDAO href9 = IGioHangDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "IGioHang";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href9);
            
            DanhMucDAO danhMucDAO = new DanhMucDAO();
            danhMucDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(danhMucDAO);
            IDanhMucDAO href10 = IDanhMucDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "IDanhMuc";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href10);
            
            LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
            loaiSanPhamDAO.setOrb(orb);
            ref = rootpoa.servant_to_reference(loaiSanPhamDAO);
            ILoaiSanPhamDAO href11 = ILoaiSanPhamDAOHelper.narrow(ref);
            objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            name = "ILoaiSanPham";
            path = ncRef.to_name(name);
            ncRef.rebind(path, href11);
            
            System.out.println("Ready..");
            
            
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Exiting ...");
    }
}
