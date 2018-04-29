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