package Corba_DAO;


/**
* Corba_DAO/ILoaiSanPhamDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public interface ILoaiSanPhamDAOOperations 
{
  DTO.LoaiSanPham[] LayDanhSach ();
  boolean Create (DTO.LoaiSanPham x);
  boolean Update (DTO.LoaiSanPham x);
  boolean Delete (int id);
  DTO.LoaiSanPham TimKiem (String search);
} // interface ILoaiSanPhamDAOOperations
