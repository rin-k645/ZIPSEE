import { apiInstance } from "./index.js";

const api = apiInstance();

function noticeList(success, fail) {
  api.get(`/board/notice`).then(success).catch(fail);
}

function writeNotice(notice, success, fail) {
  api
    .post(`/board/notice`, {
      userId: "admin",
      title: "공지사항",
      content: notice,
    })
    .then(success)
    .catch(fail);
}

function getArticle(articleno, success, fail) {
  api.get(`/board/${articleno}`).then(success).catch(fail);
}

function modifyArticle(article, success, fail) {
  api.put(`/board`, JSON.stringify(article)).then(success).catch(fail);
}

function deleteArticle(articleno, success, fail) {
  api.delete(`/board/${articleno}`).then(success).catch(fail);
}

function askList(success, fail) {
  api.defaults.headers["refresh-token"] = sessionStorage.getItem("refresh-token");
  api.get(`/mypage/ask`).then(success).catch(fail);
}

export { noticeList, writeNotice, getArticle, modifyArticle, deleteArticle, askList };
