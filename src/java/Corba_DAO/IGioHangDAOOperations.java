package Corba_DAO;


/**
* Corba_DAO/IGioHangDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public interface IGioHangDAOOperations 
{
  DTO.GioHang[] LayDanhSach (int idKhachHang);
  boolean Create (DTO.GioHang x);
  boolean Update (DTO.GioHang x);
  boolean Delete (int id);
  DTO.GioHang TimKiem (String search);
} // interface IGioHangDAOOperations