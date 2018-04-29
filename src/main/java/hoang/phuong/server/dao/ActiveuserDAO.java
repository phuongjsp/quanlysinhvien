package hoang.phuong.server.dao;

import hoang.phuong.server.model.Activeuser;

public interface ActiveuserDAO {
    Activeuser create(Activeuser activeuser);

    Activeuser getByEmail(String email);

    Activeuser getByKeyCode(String keycode);

    boolean deleteActiveuser(String email);
}
