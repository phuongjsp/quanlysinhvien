package hoang.phuong.server.dao;

import hoang.phuong.server.model.Confirmresetpassword;

public interface ConfirmresetpasswordDAO {
    Confirmresetpassword create(Confirmresetpassword confirmresetpassword);

    boolean deleteByKeyCode(String keyCode);

    Confirmresetpassword getByKeyCode(String keyCode);

    Confirmresetpassword getByByEmail(String Email);
}
