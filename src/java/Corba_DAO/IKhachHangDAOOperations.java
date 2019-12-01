package Corba_DAO;


/**
* Corba_DAO/IKhachHangDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Sunday, December 1, 2019 6:05:05 PM ICT
*/

public interface IKhachHangDAOOperations 
{
  DTO.KhachHang[] LayDanhSach ();
  boolean Create (DTO.KhachHang x);
  boolean Update (DTO.KhachHang x);
  boolean UpdateInfo (int id, String hoTen, String soDienThoai, String diaChi);
  boolean Delete (int id);
  DTO.KhachHang[] TimKiem (String search);
  DTO.KhachHang GetById (int id);
  DTO.KhachHang Login (String email, String matKhau);
} // interface IKhachHangDAOOperations
