<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  <footer id="footer">
    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6 footer-info">
            <h3>IT Solution</h3>
            <p>Chúng tôi là một trong những công ty hàng đầu của Việt Nam trong lĩnh vực năng lượng, với sứ mệnh giải quyết các thách thức về năng lượng, chống lại ô nhiễm môi trường và biến đổi khí hậu trên thế giới.</p>
          </div>

          <div class="col-lg-3 col-md-6 footer-links">
            <h4>Useful Links</h4>
            <ul>
              <li><i class="bi bi-chevron-right"></i> <a href="#">Trang chủ</a></li>
              <li><i class="bi bi-chevron-right"></i> <a href="#">Giới thiệu</a></li>
              <li><i class="bi bi-chevron-right"></i> <a href="#">Dịch vụ</a></li>
              <li><i class="bi bi-chevron-right"></i> <a href="#">Điều khoản dịch vụ</a></li>
              <li><i class="bi bi-chevron-right"></i> <a href="#">Chính sách bảo mật</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-contact">
            <h4>Liên hệ với chúng tôi</h4>
            <c:forEach var="contact" items="${contacts}">
              <p>
              <strong>Trụ sở:</strong>${contact.address}<br>
              <strong>Điện thoại:</strong> ${contact.phoneNumber}<br>
              <strong>Email:</strong> ${contact.email}<br>
            </p>
            </c:forEach>

            <div class="social-links">
              <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
              <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
              <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
              <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
              <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
            </div>

          </div>

          <div class="col-lg-3 col-md-6 footer-newsletter">
            <h4>Đăng ký nhận tin</h4>
            <p>Hãy đăng ký để được tư vấn chi tiết.</p>
            <form action="" method="post">
              <input type="email" name="email" placeholder="Email"><input type="submit" value="Đăng ký">
            </form>
          </div>

        </div>
      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; 2021 BizPage - Công ty cổ phần Giải pháp Công nghệ Việt Nam
      </div>
    </div>
  </footer>