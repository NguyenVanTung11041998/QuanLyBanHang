package Corba_DAO;


/**
* Corba_DAO/INhaSanXuatDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

public interface INhaSanXuatDAOOperations 
{
  DTO.NhaSanXuat[] LayDanhSach ();
  boolean Create (DTO.NhaSanXuat x);
  boolean Update (DTO.NhaSanXuat x);
  boolean Delete (int id);
  boolean UpdateInfo (int id, String tenNSX, String thongTin);
  DTO.NhaSanXuat[] TimKiem (String search);
  DTO.NhaSanXuat GetById (int id);
} // interface INhaSanXuatDAOOperations
