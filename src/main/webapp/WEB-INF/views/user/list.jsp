<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
      href="https://fonts.googleapis.com/css2?family=Zen+Dots&display=swap"
      rel="stylesheet"
    />
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">
<body style="font-family: 'IBM Plex Sans KR', cursive" class="bg-secondary bg-opacity-10">    
<main>
    <div class="container">
    <div class="fs-4 fw-bold pb-3 pt-5 mt-4">👥 회원 관리</div>
    <div class="text-secondary">총 1명</div>
        <div class="bg-light ps-4 pe-4 pb-1 mt-2 mb-2">
        <table class="table text-center border-none">
            <thead class="border-bottom border-3">
              <tr>
                <th>이름</th>
                <th>아이디</th>
                <th>가입일</th>
                <th>설문여부</th>
                <th>관리</th>
              </tr>
            </thead>
            <tbody class="align-middle">
                <c:forEach items="${resultMap}" var="resultData" varStatus="loop">
                    <tr>
                        <td>
                            <form action="/user/edit/${resultData.NAME}" method="get">
                                <button class="btn btn-link viewPopup text-dark"
                                    >${resultData.NAME}</button>
                            </form>
                        </td>
                        <td>${resultData.USER_ID}</td>
                        <td>${resultData.JOIN_DATE}</td>
                        <td>${resultData.SURVEYED}</td>
                        <td>
                            <form action="/user/delete/${resultData.USER_ID}" method="post">
                                <button class="btn btn btn-outline-dark btn-sm"
                                    >삭제</button>
                            </form>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</main>
</body>