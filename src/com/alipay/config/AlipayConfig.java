package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {
	

	public static String app_id = "2016092600600990";
	
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDbKyG5jTkNIhR6JoHGVtNECxqNmyVQpSCSygjR3IIPdkCH0AG32tNSfjwgVxRxiGcLca1hcuANa0crrzOg+ChH3X9mncQL9IfojzvIYSaWUgMVAuqkKU0cf3TwDIj1GwZrb7BlhI6Km6bay5ZeCouA7fOu8aZ5m6B9UQ+j8BzY7tm+BPEsCdN3LcCiqyiDfdNHlLr6futt4ZuLh5cIvFo+ppVH/yewqnfoEmpIPN+GJsGRVV09VXvrhMUpr+JeoUnbPIFML8cneCvpLhmiYUd8G/0OL42exWIScox8KX0M9Kslh8efgp7CRx0/jjIHM0EJFwUCPzG9jtvHkHMJ7zxnAgMBAAECggEBAKnztF8yh78LYl2mZpPq2EC3a4vLdxAmPDAXwucZ2zEqPbgTMIHlimE5yl45qHyxjVZufEhI0D0Xp0TUw3BbfsDbneNxC4lJweowx+cGjumaBxHQBSvvawBiRcevsLSAlGXTYjIWrIIHWUfo/11FSBBedMyATtuWNsl2hm5Vz8jXXtAPzljMpaQEbRJxrDx0xDI/ADLHobEAuvtFEesnbIrEsWy1m2kn/SFBmdgwUkb8+KW8V3H7PgfeDaHYTOeifs3TnapAYHDQbC4W8ZRr3+FFiRRBSXkP89FRGLmXJMMwYHHltI0xp88kcvmUavReCOnlVjFVWqjVuHcwXdrd+8ECgYEA+jY8JGZ1mQs8ZVh+UqQMLhTAHO4JILeZMh4CVKdQKKOPLGqQpXUKWvHanm3eV0fd5TfRs+9Kp0JL1tlm2Enq/BC9+TLRx/iaKC7QL8ibul2rOsj0YGol3VzKGVa+e7ZBzWdloLTETYCciGDUc6ks7HkfxAMJB7/wOvD4BOei1S8CgYEA4D0OgVQus9boBZlzJNQDmveyFsFxuCGG1c/uQKqt+8ulSBhAye5lLzDcCi/K3SgvMSpmUVH6Y3xJ2VakkJ6osM3jKTnB4nvvVpH915QG2rqsRM9x9FoS7jn0kIK7MEZ+Ivw5Nf6POQ2JxHP57/i1M6iTxm8Virzgkjmqo+BuLkkCgYAtsTnKa+uNxz+AQmjPLqYKxD9RCSchkmWngVNroiJBSZ0bv1oq3PTHJuOFiwrPZZBgC5GACnLXmIPA+HKPjPAcl/IZT+5/VibQr7vU/g1yOyjJ02jNMpU3l3pQpkai0OWzXO5yKpCulo3/Wa9yb7KEfJoQcX10rNhx6w9f1e0mgQKBgQCgvqQbScGA4dnJycqk5+b9u/pKHbnriP0jYL8mVDQMgFunZttq5h5ayeey1bfS+e96iy51tRKNJpe52UZ29YVv2OeysdivBrD3mggh9ddEDPVZDmxeAgP4CkurHEwbuyzI344TirwY5f+QeKL+x4b91Sa55P/ISMWjjPsqJsRVIQKBgD+XYRJKwPAHcEFxwV/0LGu+hN/Nlqa0vfy951aritGDcB+UyZjIC9utSTg5pPvW0C3TZhM8DVWX6HIJnZAaVsiOVoz94TyzEGILz/Zd8y55njfQuXjvR0Je8Gm48z1aYhadAHXNwLg08UC8Hyi+zSZe8VAMyWg42cO3Twe4/bmn";
	
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuM8dz+8SF7BMG4fxuhjmg2lwgz4izXIynFmYHk544HyVwFAV2h1pL0n0sbvxwmdQ3OLcesr0ZliZ8lV6Hw/flfiFRcBoNuzO4ZFn+tdg5oGcx/yShqqWfZI7gn/IjNhq9yy0Lthv6d39CDsiJ/u2sHmChWEycpy2TCwiEdsbg5AmyhWQF5EP+YJk2briPY0Safur5jmLBAbzJU9fCDvZWdk1Max5x5dkd+oBVTUPLHBdiAbam9KNCKkGW7AwqFsU2LygVk+rQabnq05m3kqpHz4v0mW+pV0lGTke6dT4arPoXpKF++NkH+MOTE9DHXG+8lKpvWMNjVN3llDBuWoS+QIDAQAB";

	public static String notify_url = "http://localhost:8080/shopping-result.jsp";

	public static String return_url = "http://localhost:8080/TMSshopping/shopping-result.jsp";

	public static String sign_type = "RSA2";
	
	public static String charset = "utf-8";
	
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	public static String log_path = "C:\\Users\\LINCK\\Desktop\\PAY-LOGIN";



    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

