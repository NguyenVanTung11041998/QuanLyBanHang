package Corba_DAO;


/**
* Corba_DAO/IPhieuNhapDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public interface IPhieuNhapDAOOperations 
{
  DTO.PhieuNhap[] LayDanhSach ();
  boolean Create (DTO.PhieuNhap x);
  boolean Update (DTO.PhieuNhap x);
  boolean Delete (int id);
  DTO.PhieuNhap TimKiem (String date);
} // interface IPhieuNhapDAOOperations