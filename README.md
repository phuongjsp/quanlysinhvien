# Quản lý sinh viên Rest API
### Contact me
- Fullname : Hoàng Văn Phương
- PhoneNumber : [+841653933445](tel:+841653933445)
- Email : [phuong.jsp@gmail.com](mailto:phuong.jsp@gmail.com)
- FaceBook : [facebook.com/jsp.phuong](https://www.facebook.com/jsp.phuong)
- Linkedin : [linkedin.com/in/phuong-jsp](https://www.linkedin.com/in/phuong-jsp)
##Introduction
This is a student information management API project
###IDE 
- XAMPP
    - mysql
- IntelliJ IDEA Ultimate
### Technology 
- Spring MVC
- Spring Security
- Hibernate
- MySQL 
- Logback 
### METHOD USING
````| DiaChi                               |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
|--------------------------------------|-------------------------------------------|--------------|--------------------------------------------------------|-----------------------------|--------------------------------------------------------------------|--------------------|---------------|--------------------| 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/diachi                              | X-XSRF-TOKEN |                                                        | DiaChi                      | Insert Dia Chi                                                     | USER               |               | Dia Chi            | 
| GET                                  | /qlsv/diachi/{id}                         | X-XSRF-TOKEN | int id                                                 |                             | Get Dia Chi by Id                                                  | USER               |               | Dia Chi            | 
| PUT                                  | /qlsv/diachi                              | X-XSRF-TOKEN |                                                        | DiaChi                      | Update Dia Chi by Id                                               | USER               |               | Boolean            | 
| DELETE                               | /qlsv/diachi/{id}                         | X-XSRF-TOKEN | int id                                                 |                             | Delete Diachi By Id                                                | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| GiayTo                               |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/giayto                              | X-XSRF-TOKEN |                                                        | GiayTo                      | Insert Giay To                                                     | USER               |               | Giay To            | 
| GET                                  | /qlsv/giayto/{id}                         | X-XSRF-TOKEN |                                                        |                             | Get Giay To By Id                                                  | USER               |               | Giay To            | 
| GET                                  | /qlsv/giayto/maGT-{maGT}                  | X-XSRF-TOKEN | String maGayTo                                         |                             | Get Giay To By maGiayTo                                            | USER               |               | Giay To            | 
| GET                                  | /qlsv/giayto/SVisEmpty-{maSv}             | X-XSRF-TOKEN | String maSinhVien                                      |                             | Get List Giay to if Sinh Vien has no available                     | USER               |               | List<GiayTo>       | 
| PUT                                  | /qlsv/giayto                              | X-XSRF-TOKEN |                                                        | GiayTo                      | Update Giay to by Id Giay To                                       | USER               |               | Boolean            | 
| DELETE                               | /qlsv/giayto/{id}                         | X-XSRF-TOKEN | int id                                                 |                             | DELETE Giay To By ID                                               | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Khoa                                 |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/khoa                                | X-XSRF-TOKEN |                                                        | Khoa                        | Insert Khoa                                                        | USER               |               | Khoa               | 
| GET                                  | /qlsv/khoa/{id}                           | X-XSRF-TOKEN | int id                                                 |                             | Get Khoa By id                                                     | USER               |               | Khoa               | 
| GET                                  | /qlsv/khoa/maKhoa-{maKhoa}                | X-XSRF-TOKEN | String maKhoa                                          |                             | Get Khoa By Ma Khoa                                                | USER               |               | Khoa               | 
| GET                                  | /qlsv/khoa                                | X-XSRF-TOKEN |                                                        |                             | Get List of All Khoa                                               | USER               |               | List<Khoa>         | 
| PUT                                  | /qlsv/khoa                                | X-XSRF-TOKEN |                                                        |                             | Update Khoa By Id                                                  | USER               |               | Boolean            | 
| DELETE                               | /qlsv/khoa/{id}                           | X-XSRF-TOKEN | int id                                                 |                             | DELETE Khoa By Id                                                  | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Lop                                  |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/lopsv                               | X-XSRF-TOKEN |                                                        | LopSv                       | Insert LopSv                                                       | USER               |               | LopSv              | 
| GET                                  | /qlsv/lopsv/maLop-{maLop}                 | X-XSRF-TOKEN | String MaLop                                           |                             | Get Lop By MaLop                                                   | USER               |               | LopSv              | 
| GET                                  | /qlsv/lopsv/{id}                          | X-XSRF-TOKEN | int id                                                 |                             | Get Lop By ID                                                      | USER               |               | LopSv              | 
| GET                                  | /qlsv/lopsv                               | X-XSRF-TOKEN |                                                        |                             | Get List of All LopSv                                              | USER               |               | List<LopSv>        | 
| PUT                                  | /qlsv/lopsv                               | X-XSRF-TOKEN |                                                        | LopSv                       | Update LopSv By MaLop                                              | USER               |               | Boolean            | 
| DELETE                               | /qlsv/lopsv/maLop-{maLop}                 | X-XSRF-TOKEN | String MaLop                                           |                             | DELETE LopSv By MaLop                                              | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Nganh Dao Tao                        |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/nganhdaotao                         | X-XSRF-TOKEN |                                                        | Nganh Dao Tao               | Insert Nganh Dao Tao                                               | USER               |               | Nganh Dao Tao      | 
| GET,"/qlsv/nganhdaotao/{id}"""       | X-XSRF-TOKEN                              | int id       |                                                        | Get Nganh Dao Tao By ID     | USER                                                               |                    | Nganh Dao Tao |                    | 
| GET                                  | /qlsv/nganhdaotao/maNganh-{maNganh}       | X-XSRF-TOKEN | String MaNganh                                         |                             | Get Nganh Dao Tao By MaNganh                                       | USER               |               | Nganh Dao Tao      | 
| GET                                  | /qlsv/nganhdaotao                         | X-XSRF-TOKEN |                                                        |                             | Get List of All Nganh Dao Tao                                      | USER               |               | List<NganhDaoTao>  | 
| PUT                                  | /qlsv/nganhdaotao                         | X-XSRF-TOKEN |                                                        | Nganh Dao Tao               | Update Nganh Dao Tao                                               | USER               |               | Boolean            | 
| DELETE                               | /qlsv/nganhdaotao/maNganh-{maNganh}       |              | String MaNganh                                         |                             | DELETE Nganh Dao Tao By MaNganh                                    | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Sinhviencogiayto                     |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/sinhviencogiayto                    | X-XSRF-TOKEN |                                                        | SinhVienCoGiayTo            | Insert SinhVienCoGiayTo(SvCoGt)                                    | USER               |               | SvCoGt             | 
| GET                                  | /qlsv/sinhviencogiayto/{id}               | X-XSRF-TOKEN | int id                                                 |                             | Get SvCoGt By Id                                                   | USER               |               | SvCoGt             | 
| GET                                  | /qlsv/sinhviencogiayto                    | X-XSRF-TOKEN |                                                        |                             | Get List of All SvCoGt                                             | USER               |               | List<SvCoGt>       | 
| GET                                  | /qlsv/sinhviencogiayto/maSv-{maSv}        | X-XSRF-TOKEN | String maSv                                            |                             | Get List SvCoGt By maSv                                            | USER               |               | List<SvCoGt>       | 
| PUT                                  | /qlsv/sinhviencogiayto                    | X-XSRF-TOKEN |                                                        | SinhVienCoGiayTo            | Update SvCoGt                                                      | USER               |               | Boolean            | 
| DELETE                               | /qlsv/sinhviencogiayto/{id}               | X-XSRF-TOKEN | int id                                                 |                             | DELETE SvCoGt By Id                                                | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| SvCoVb                               |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/svcovb                              | X-XSRF-TOKEN |                                                        | SvCoVb                      | Insert Sinh Vien Co Van Bang(SvCoVb)                               | USER               |               | SvCoVb             | 
| GET                                  | /qlsv/svcovb/{id}                         | X-XSRF-TOKEN | int id                                                 |                             | Get SvCoVb By Id                                                   | USER               |               | SvCoVb             | 
| GET,"/qlsv/svcovb/maSV-{MaSv}"""     | X-XSRF-TOKEN                              | String maSv  |                                                        | Get List SvCoVb By MaSv     | USER                                                               |                    | List<SvCoVb>  |                    | 
| GET                                  | /qlsv/svcovb/maVB-{maVB}                  | X-XSRF-TOKEN | String maVb                                            |                             | Get List SvCoVb By MaVb                                            | USER               |               | List<SvCoVb>       | 
| GET                                  | /qlsv/svcovb/only/maSV-{MaSv}-maVB-{maVB} | X-XSRF-TOKEN | "String MaSv,String MaVb"                              |                             | Get List SvCoVb By MaSv and MaVb                                   | USER               |               | List<SvCoVb>       | 
| PUT                                  | /qlsv/svcovb                              | X-XSRF-TOKEN |                                                        | SvCoVb                      | Update SvCoVb                                                      | USER               |               | Boolean            | 
| DELETE                               | /qlsv/svcovb/{id}                         | X-XSRF-TOKEN | int id                                                 |                             | DELETE SvCoVb By Id                                                | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Thongtingiadinh                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/thongtingiadinh                     | X-XSRF-TOKEN |                                                        | ThongTinGiaDinh             | InsertThongTinGiaDinh (TTGD)                                       | USER               |               | TTGD               | 
| GET                                  | /qlsv/thongtingiadinh/{id}                | X-XSRF-TOKEN | int id                                                 |                             | Get TTGD By Id                                                     | USER               |               | TTGD               | 
| GET                                  | /qlsv/thongtingiadinh/IDSV-{idsv}         | X-XSRF-TOKEN | int idSv                                               |                             | Get List TTGD By IdSv                                              | USER               |               | List<TTGD>         | 
| PUT                                  | /qlsv/thongtingiadinh                     | X-XSRF-TOKEN |                                                        | ThongTinGiaDinh             | Update TTGD                                                        | USER               |               | Boolean            | 
| DELETE                               | /qlsv/thongtingiadinh/{id}                | X-XSRF-TOKEN | int id                                                 |                             | DELETE TTGD By ID                                                  | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Thongtinsinhvien                     |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/thongtinsinhvien                    | X-XSRF-TOKEN |                                                        | ThongTinSinhVien            | Insert Thong tin sinh vien (TTSV)                                  | USER               |               | TTSV               | 
| GET                                  | /qlsv/thongtinsinhvien/{id}               | X-XSRF-TOKEN | int id                                                 |                             | Get TTSV By ID                                                     | USER               |               | TTSV               | 
| GET                                  | /qlsv/thongtinsinhvien/maSV-{maSV}        | X-XSRF-TOKEN | String maSv                                            |                             | Get TTSv By MaSv                                                   | USER               |               | TTSV               | 
| POST                                 | /qlsv/thongtinsinhvien/fliter/{min}/{max} | X-XSRF-TOKEN | "int min,int max"                                      | "List<Map<String, Object>>" | "Get List TTSV By List property,Order By value and min max result" | USER               |               | List<TTSV>         | 
| PUT                                  | /qlsv/thongtinsinhvien                    | X-XSRF-TOKEN |                                                        | ThongTinSinhVien            | Update TTSV                                                        | USER               |               | Boolean            | 
| DELETE                               | /qlsv/thongtinsinhvien/maSV-{maSV}        | X-XSRF-TOKEN | String maSv                                            |                             | DELETE TTSV by MaSv                                                | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| thongtinthem                         |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/thongtinthem                        | X-XSRF-TOKEN |                                                        | Thongtinthem                | SAVE ThongTinThem                                                  | USER               |               | Thongtinthem       | 
| GET                                  | /qlsv/thongtinthem/{id}                   | X-XSRF-TOKEN | int id                                                 |                             | Get Thongtinthem by Id                                             | USER               |               | Thongtinthem       | 
| GET                                  | /qlsv/thongtinthem//maSv-{maSv}           | X-XSRF-TOKEN | String MaSv                                            |                             | Get Thongtinthem by MaSv                                           | USER               |               | Thongtinthem       | 
| GET                                  | /qlsv/thongtinthem                        | X-XSRF-TOKEN |                                                        |                             | Get List of all Thongtinthem                                       | USER               |               | List<Thongtinthem> | 
| PUT                                  | /qlsv/thongtinthem                        | X-XSRF-TOKEN |                                                        | Thongtinthem                | Update Thongtinthem                                                | USER               |               | Boolean            | 
| DELETE                               | /qlsv/thongtinthem/{id}                   | X-XSRF-TOKEN | int id                                                 |                             | Delete Thongtinthem By Id                                          | USER               |               | Boolean            | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| VanBang                              |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /qlsv/vanbang                             | X-XSRF-TOKEN |                                                        | VanBang                     | Save Van Bang                                                      | USER               |               | VanBang            | 
| GET                                  | /qlsv/vanbang                             | X-XSRF-TOKEN |                                                        |                             | Get List of All                                                    | USER               |               | List<VanBang>      | 
| GET                                  | /qlsv/vanbang/{id}                        | X-XSRF-TOKEN | int id                                                 |                             | Get VanBang By Id                                                  | USER               |               | VanBang            | 
| GET                                  | /qlsv/vanbang/maVB-{maVB}                 | X-XSRF-TOKEN | String maVb                                            |                             | Get VanBang By MaVb                                                | USER               |               | VanBang            | 
| PUT                                  | /qlsv/vanbang                             | X-XSRF-TOKEN |                                                        | VanBang                     | Update Van Bang                                                    | USER               |               | Boolean            | 
| DELETE,"/qlsv/vanbang""/maVB-{maVB}" | X-XSRF-TOKEN                              | String maVb  |                                                        | Delete Van Bang By MaVb     | USER                                                               |                    | Boolean       |                    | 
|                                      |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| API                                  |                                           |              |                                                        |                             |                                                                    |                    |               |                    | 
| Method                               | Path                                      | Header       | RequestParam                                           | RequestBody                 | Description                                                        | Permission         | ResponseCode  | ResponseBody       | 
| POST                                 | /api/login                                |              | "String email,String password"                         |                             | Login using email                                                  |                    |               | USER               | 
| POST                                 | /api/logout                               | X-XSRF-TOKEN |                                                        |                             | Logout witch user                                                  | USER(this)         |               |                    | 
| POST                                 | /api/users                                |              |                                                        | Activeuser                  | Register User and send confirm link to email                       |                    |               |                    | 
| POST                                 | /api/users/active/{KeyCode}               |              | "String KeyCode,String password"                       |                             | Confirm and active User                                            |                    |               | USER               | 
| GET                                  | /api/users                                | X-XSRF-TOKEN |                                                        |                             | Get all of list User                                               | ADMIN              |               | List<USER>         | 
| GET                                  | /api/users/{id}                           | X-XSRF-TOKEN | int idUser                                             |                             | Get User By Id                                                     | "ADMIN,USER(this)" |               | USER               | 
| PUT                                  | /api/users/{id}                           | X-XSRF-TOKEN | int idUser                                             |                             | Update User by Id                                                  | "ADMIN,USER(this)" |               | USER               | 
| PATCH                                | /api/users/{id}                           | X-XSRF-TOKEN | "int idUser,String currentPassword,String newPassword" |                             | Update password User                                               | "ADMIN,USER(this)" |               |                    | 
| DELETE                               | /api/users/{id}                           | X-XSRF-TOKEN | "int idUser,String password"                           |                             | Delete User using User password                                    | "ADMIN,USER(this)" |               |                    | 
| PATCH                                | /api/users                                |              | String email                                           |                             | Reset User password and send confirm link to email                 |                    |               |                    | 
| POST                                 | /api/users/reset/{KeyCode}                |              | "String KeyCode,String password"                       |                             | Reset and Update Password for user                                 |                    |               | USER               | 
````
### Exceptions response 
| Exception                              | ResponseCode | ResponseBody                                          |
|----------------------------------------|:------------:|-------------------------------------------------------|
| BindException                          | 400          | { "url" : "...", "cause" : "...", "details" : [...] } |
| MethodArgumentNotValidException        | 400          | { "url" : "...", "cause" : "...", "details" : [...] } |
| ValidationException                    | 400          | { "url" : "...", "cause" : "...", "details" : [...] } |
| InternalAuthenticationServiceException | 401          | { "url" : "...", "cause" : "...", "details" : [...] } |
| AccessDeniedException                  | 403          | { "url" : "...", "cause" : "...", "details" : [...] } |
| NoHandlerFoundException                | 404          | { "url" : "...", "cause" : "...", "details" : [...] } |
| EntityAlreadyExistsException           | 409          | { "url" : "...", "cause" : "...", "details" : [...] } |
| HttpMediaTypeNotSupportedException     | 415          | { "url" : "...", "cause" : "...", "details" : [...] } |
| EntityNotFoundException                | 422          | { "url" : "...", "cause" : "...", "details" : [...] } |
| Exception                              | 500          | { "url" : "...", "cause" : "...", "details" : [...] } |