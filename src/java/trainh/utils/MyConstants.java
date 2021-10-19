/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.utils;

import java.io.Serializable;

/**
 *
 * @author trainh
 */
public class MyConstants implements Serializable {

    public static final int TOTAL_ITEM_IN_PAGE = 4;

    //Role
    public static final int ROLE_USER = 2,
            ROLE_AD = 1;

    //Status
    public static final int STATUS_NEW = 1,
            STATUS_ACTIVE = 2,
            STATUS_INACTIVE = 3,
            STATUS_ACCEPT = 4,
            STATUS_DELETE = 5;
    
    //Role use Servlet and Page
    public static final int USER_AND_ADMIN = 3,
            USER = 2,
            ADMIN = 1;
}
