package Corba_DAO;


/**
* Corba_DAO/INhaSanXuatDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 28, 2019 5:56:13 PM ICT
*/

public interface INhaSanXuatDAOOperations 
{
  DTO.NhaSanXuat[] LayDanhSach ();
  boolean Create (DTO.NhaSanXuat x);
  boolean Update (DTO.NhaSanXuat x);
  boolean Delete (int id);
  DTO.NhaSanXuat[] TimKiem (String search);
  DTO.NhaSanXuat GetById (int id);
} // interface INhaSanXuatDAOOperations
