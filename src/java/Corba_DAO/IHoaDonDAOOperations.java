package Corba_DAO;


/**
* Corba_DAO/IHoaDonDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public interface IHoaDonDAOOperations 
{
  DTO.HoaDon[] LayDanhSach ();
  boolean Create (DTO.HoaDon x);
  boolean Update (DTO.HoaDon x);
  boolean Delete (int id);
  DTO.DanhMuc TimKiem (String date);
} // interface IHoaDonDAOOperations