/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author thuan
 */
public class Helper {

    public String TenTaiKhoan;

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void LayTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }
}
