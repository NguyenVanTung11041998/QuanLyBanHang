package Corba_DAO;


/**
* Corba_DAO/IPhieuNhapChiTietDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

public interface IPhieuNhapChiTietDAOOperations 
{
  DTO.PhieuNhapChiTiet[] LayDanhSach (int idPhieuNhap);
  boolean Create (DTO.PhieuNhapChiTiet x);
  boolean Update (DTO.PhieuNhapChiTiet x);
  boolean Delete (int maPhieuNhap, int maSP);
  DTO.PhieuNhapChiTiet GetById (int id);
} // interface IPhieuNhapChiTietDAOOperations
