package Corba_DAO;


/**
* Corba_DAO/INhaSanXuatDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 21, 2019 4:26:39 PM ICT
*/

public interface INhaSanXuatDAOOperations 
{
  DTO.NhaSanXuat[] LayDanhSach ();
  boolean Create (DTO.NhaSanXuat x);
  boolean Update (DTO.NhaSanXuat x);
  boolean Delete (int id);
  DTO.NhaSanXuat TimKiem (String search);
} // interface INhaSanXuatDAOOperations
