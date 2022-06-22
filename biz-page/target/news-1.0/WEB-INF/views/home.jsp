<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>IT Solution</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: BizPage - v5.8.0
  * Template URL: https://bootstrapmade.com/bizpage-bootstrap-business-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <jsp:include page="header.jsp"></jsp:include>
  <!-- End Header -->

  <!-- ======= hero Section ======= -->
  <section id="hero">
    <div class="hero-container">
      <div id="heroCarousel" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="5000">

        <ol id="hero-carousel-indicators" class="carousel-indicators"></ol>

        <div class="carousel-inner" role="listbox">

          <div class="carousel-item active" style="background-image: url(assets/img/hero-carousel/1.jpg)">
            <div class="carousel-container">
              <div class="container">
                <h2 class="animate__animated animate__fadeInDown">Dịch vụ tư vấn</h2>
                <p class="animate__animated animate__fadeInUp">Chúng tôi cam kết cung cấp cho khách hàng những dịch vụ tư vấn và giải pháp tối ưu nhất, phù hợp với nhu cầu và thách thức riêng của mỗi doanh nghiệp, tổ chức.</p>
                <a href="#featured-services" class="btn-get-started scrollto animate__animated animate__fadeInUp">Get Started</a>
              </div>
            </div>
          </div>

          <div class="carousel-item" style="background-image: url(assets/img/hero-carousel/2.jpg)">
            <div class="carousel-container">
              <div class="container">
                <h2 class="animate__animated animate__fadeInDown">Dịch vụ triển khai</h2>
                <p class="animate__animated animate__fadeInUp">Công ty TNHH Giải pháp Công nghệ Cộng (TechPlus) thực hiện việc chuyển giao công nghệ và nghiệp vụ theo phương pháp triển khai quy chuẩn, kết hợp với kinh nghiệm triển khai trên các mô hình và đối tượng khác nhau để đảm bảo mọi dự án thực hiện đều thành công.</p>
                <a href="#featured-services" class="btn-get-started scrollto animate__animated animate__fadeInUp">Get Started</a>
              </div>
            </div>
          </div>

          <div class="carousel-item" style="background-image: url(assets/img/hero-carousel/3.jpg)">
            <div class="carousel-container">
              <div class="container">
                <h2 class="animate__animated animate__fadeInDown">Dịch vụ hỗ trợ, bảo hành và bảo trì</h2>
                <p class="animate__animated animate__fadeInUp">Cùng với phát triển và triển khai, Công ty TNHH Giải pháp Công nghệ Cộng (TechPlus) cung cấp dịch vụ vận hành, hỗ trợ, bảo hành và bảo trì trong suốt vòng đời của sản phẩm. Khách hàng sẽ được cung cấp các công cụ và dịch vụ hỗ trợ chuyên nghiệp từ đội ngũ chuyên gia tư vấn nội địa cũng như đội ngũ hỗ trợ từ chính hãng.</p>
                <a href="#featured-services" class="btn-get-started scrollto animate__animated animate__fadeInUp">Get Started</a>
              </div>
            </div>
          </div>

        </div>

        <a class="carousel-control-prev" href="#heroCarousel" role="button" data-bs-slide="prev">
          <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
        </a>

        <a class="carousel-control-next" href="#heroCarousel" role="button" data-bs-slide="next">
          <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
        </a>

      </div>
    </div>
  </section><!-- End Hero Section -->

  <main id="main">

    <!-- ======= Featured Services Section Section ======= -->
    <section id="featured-services">
      <div class="container">
        <div class="row">
		<c:forEach items="${services}" var="service" end="2">
          <div class="col-lg-4 box">
            <i class="bi ${service.icon}"></i>
            <h4 class="title"><a href="">${service.name}</a></h4>
            <p class="description">${service.description}</p>
            <div id="client"></div>
          </div>
		</c:forEach>
        </div>
      </div>
    </section><!-- End Featured Services Section -->

    <!-- ======= About Us Section ======= -->
    <section id="about">
      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3>VỀ CHÚNG TÔI</h3>
          <p>Công ty TNHH Đầu tư Dịch vụ và Giải pháp Công nghệ CQL ra đời nhằm cung cấp cho xã hội các giải pháp công nghệ thông tin tiên tiến nhất. Với triết ký kinh doanh bằng năng lực, sự tận tụy với khách hàng, nắm bắt xu hướng phát triển CNTT của thế giới, CQL đã giúp các doanh nghiệp và tổ chức trên khắp Việt Nam kinh doanh có hiệu quả, cũng như hỗ trợ công tác quản lý của các cơ quan Nhà nước.</p>
        </header>

        <div class="row about-cols">
		  <c:forEach items="${abouts}" var="about">
          <div class="col-md-4" data-aos="fade-up" data-aos-delay="100">
            <div class="about-col">
              <div class="img">
                <img src="${about.image}" alt="" class="img-fluid">
                <div class="icon"><i class="bi ${about.icon}"></i></div>
              </div>
              <h2 class="title"><a href="#">${about.name}</a></h2>
              <p>
                ${about.description}
              </p>
            </div>
          </div>
		</c:forEach>
        </div>

      </div>
    </section><!-- End About Us Section -->

    <!-- ======= Services Section ======= -->
    <section id="services">
      <div class="container" data-aos="fade-up">

        <header class="section-header wow fadeInUp">
          <h3>DỊCH VỤ & GIẢI PHÁP</h3>
          <p>Chúng tôi cung cấp các giải pháp công nghệ với chất lượng tối ưu nhằm thỏa mãn tối đa nhu cầu của khách hàng.</p>
        </header>

        <div class="row">
		  <c:forEach items="${services}" var="service">
	          <div class="col-lg-4 col-md-6 box" data-aos="fade-up" data-aos-delay="100">
	            <div class="icon"><i class="bi ${service.icon}"></i></div>
	            <h4 class="title"><a href="">${service.name}</a></h4>
	            <p class="description">${service.description}</p>
	          </div>
		  </c:forEach>
        </div>

      </div>
    </section><!-- End Services Section -->

    <!-- ======= Call To Action Section ======= -->
    <section id="call-to-action">
      <div class="container text-center" data-aos="zoom-in">
        <h3>Call To Action</h3>
        <p> Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <a class="cta-btn" href="#">Call To Action</a>
      </div>
    </section><!-- End Call To Action Section -->

    <!-- ======= Skills Section ======= -->
    <section id="skills">
      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3>Kỹ năng</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip</p>
        </header>

        <div class="skills-content">
		<c:forEach items="${skills}" var="skill">
          <div class="progress">
            <div class="progress-bar ${skill.progressBarColor }" role="progressbar" aria-valuenow="${skill.level}" aria-valuemin="0" aria-valuemax="100">
              <span class="skill">${skill.language } <i class="val">${skill.level} %</i></span>
            </div>
          </div>
		</c:forEach>

        </div>

      </div>
    </section><!-- End Skills Section -->

    <!-- ======= Facts Section ======= -->
    <section id="facts">
      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3>Facts</h3>
    	  <c:forEach items="${facts}" var="fact">
          <p>${fact.comment}</p>
        </header>

        <div class="row counters">
		  <c:forEach items="${fact.factDetails}" var="factdetail">
          <div class="col-lg-3 col-6 text-center">
            <span data-purecounter-start="0" data-purecounter-end="${factdetail.quantity}" data-purecounter-duration="1" class="purecounter"></span>
            <p>${factdetail.category}</p>
          </div>
		  </c:forEach>
        </div>

        <div class="facts-img">
          <img src="${fact.image}" alt="" class="img-fluid">
        </div>
		</c:forEach>
      </div>
    </section><!-- End Facts Section -->

    <!-- ======= Portfolio Section ======= -->
    <section id="portfolio" class="section-bg">
      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3 class="section-title">Sản phẩm</h3>
        </header>

        <div class="row" data-aos="fade-up" data-aos-delay="100"">
      <div class=" col-lg-12">
          <ul id="portfolio-flters">
            <li data-filter="*" class="filter-active">All</li>
            <li data-filter=".filter-app">App</li>
            <li data-filter=".filter-card">Card</li>
            <li data-filter=".filter-web">Web</li>
          </ul>
        </div>
      </div>

      <div class="row portfolio-container" data-aos="fade-up" data-aos-delay="200">

	<c:forEach items="${categories}" var="category">
		<c:forEach items="${category.portfolios}" var="portfolio">
	        <div class="col-lg-4 col-md-6 portfolio-item ${portfolio.filter}">
	          <div class="portfolio-wrap">
	            <figure>
	              <img src="${portfolio.image}" class="img-fluid" alt="">
	              <a href="${portfolio.image}" class="link-preview portfolio-lightbox" data-gallery="portfolioGallery" title="${portfolio.name}"><i class="bi bi-plus"></i></a>
	              <a id="detail" data-id="${portfolio.id}" class="link-details" title="More Details"><i class="bi bi-link"></i></a>
	            </figure>
	
	            <div class="portfolio-info">
	              <h4>${portfolio.name}</h4>
	              	<p>${category.categoryName}</p>
	            </div>
	          </div>
	        </div>
        </c:forEach>
	</c:forEach>
      </div>

      </div>
    </section><!-- End Portfolio Section -->

    <!-- ======= Our Clients Section ======= -->
    <section id="clients">
      <div class="container" data-aos="zoom-in">

        <header class="section-header">
          <h3>Khách hàng & Đối tác</h3>
        </header>

        <div class="clients-slider swiper">
          <div class="swiper-wrapper align-items-center">
          	<c:forEach items="${clients}" var="client">
            	<div class="swiper-slide"><img src="${client.image}" class="img-fluid" alt=""></div>
            </c:forEach>
          </div>
          <div class="swiper-pagination"></div>
        </div>

      </div>
    </section><!-- End Our Clients Section -->

    <!-- ======= Testimonials Section ======= -->
    <section id="testimonials" class="section-bg">
      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3>Đánh giá của khách hàng</h3>
        </header>

        <div class="testimonials-slider swiper" data-aos="fade-up" data-aos-delay="100">
          <div class="swiper-wrapper">
			<c:forEach items="${testimonials}" var="testimonial">
            <div class="swiper-slide">
              <div class="testimonial-item">
              	<c:forEach items="${testimonial.members}" var="member">
                <img src="${member.avatar}" class="testimonial-img" alt="">
                <h3>${member.name}</h3>
                <h4>${member.department.departmentName }</h4>
                </c:forEach>
                <p>
                  <img src="assets/img/quote-sign-left.png" class="quote-sign-left" alt="">
                  ${testimonial.comment}
                  <img src="assets/img/quote-sign-right.png" class="quote-sign-right" alt="">
                </p>
              </div>
            </div><!-- End testimonial item -->
			</c:forEach> 
          </div>
          <div class="swiper-pagination"></div>
        </div>

      </div>
    </section><!-- End Testimonials Section -->

    <!-- ======= Team Section ======= -->
    <section id="team">
      <div class="container" data-aos="fade-up">
        <div class="section-header">
          <h3>Đội ngũ</h3>
          <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque</p>
        </div>

        <div class="row">
        <c:forEach items="${teams}" var="team">
          <div class="col-lg-3 col-md-6">
            <div class="member" data-aos="fade-up" data-aos-delay="100">
              <c:forEach items="${team.members}" var="member">
              <img src="${member.avatar}" class="img-fluid" alt="">
              <div class="member-info">
                <div class="member-info-content">
                  <h4>${member.name}</h4>
                  	<span>${member.department.departmentName}</span>
                  <div class="social">
                    <a href=""><i class="bi bi-twitter"></i></a>
                    <a href=""><i class="bi bi-facebook"></i></a>
                    <a href=""><i class="bi bi-instagram"></i></a>
                    <a href=""><i class="bi bi-linkedin"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          </c:forEach> 
		</c:forEach>
        </div>

      </div>
    </section><!-- End Team Section -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="section-bg">
      <div class="container" data-aos="fade-up">

        <div class="section-header">
          <h3>Liên hệ với chúng tôi</h3>
          <p>Để tìm hiểu thêm về các sản phẩm của chúng tôi và các ưu đãi đặc biệt</p>
        </div>

        <div class="row contact-info">
		  <c:forEach var="contact" items="${contacts}">
          <div class="col-md-4">
            <div class="contact-address">
              <i class="bi bi-geo-alt"></i>
              <h3>Trụ sở</h3>
              <address>${contact.address}</address>
            </div>
          </div>

          <div class="col-md-4">
            <div class="contact-phone">
              <i class="bi bi-phone"></i>
              <h3>Điện thoại</h3>
              <p><a href="tel:+155895548855">${contact.phoneNumber}</a></p>
            </div>
          </div>

          <div class="col-md-4">
            <div class="contact-email">
              <i class="bi bi-envelope"></i>
              <h3>Email</h3>
              <p><a href="mailto:info@example.com">${contact.email}</a></p>
            </div>
          </div>
          </c:forEach>

        </div>

        <div class="form">
          <form action="forms/contact.php" method="post" role="form" class="php-email-form">
            <div class="row">
              <div class="form-group col-md-6">
                <input type="text" name="name" class="form-control" id="name" placeholder="Tên của bạn" required>
              </div>
              <div class="form-group col-md-6">
                <input type="email" class="form-control" name="email" id="email" placeholder="Địa chỉ email" required>
              </div>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" name="subject" id="subject" placeholder="Chủ đề" required>
            </div>
            <div class="form-group">
              <textarea class="form-control" name="message" rows="5" placeholder="Tin nhắn" required></textarea>
            </div>
            <div class="my-3">
              <div class="loading">Loading</div>
              <div class="error-message"></div>
              <div class="sent-message">Tin nhắn của bạn đã được gửi đến đội ngũ chúng tôi.Cảm ơn bạn!</div>
            </div>
            <div class="text-center"><button type="submit">Để lại lời nhắn</button></div>
          </form>
        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <jsp:include page="footer.jsp"></jsp:include>
  <!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
  <!-- Uncomment below i you want to use a preloader -->
  <!-- <div id="preloader"></div> -->

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script src="js/custom.js"></script>

</body>

</html>