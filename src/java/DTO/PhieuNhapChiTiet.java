package DTO;


/**
* DTO/PhieuNhapChiTiet.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 21, 2019 9:15:49 PM ICT
*/

public final class PhieuNhapChiTiet implements org.omg.CORBA.portable.IDLEntity
{
  public int maPN = (int)0;
  public int maSP = (int)0;
  public int soLuongNhap = (int)0;
  public float donGiaNhap = (float)0;

  public PhieuNhapChiTiet ()
  {
  } // ctor

  public PhieuNhapChiTiet (int _maPN, int _maSP, int _soLuongNhap, float _donGiaNhap)
  {
    maPN = _maPN;
    maSP = _maSP;
    soLuongNhap = _soLuongNhap;
    donGiaNhap = _donGiaNhap;
  } // ctor

} // class PhieuNhapChiTiet
