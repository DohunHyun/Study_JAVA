let loginId, loginPw;
window.onload = function () {
  console.log("whatthe??");

  document.querySelector("#login").addEventListener("click", function () {
    console.log("clicked??");
    loginId = prompt("input id");
    loginPw = prompt("input password");

    if (
      loginId != "" &&
      loginId == "ssafy" &&
      loginPw != "" &&
      loginPw == "1234"
    ) {
      alert("login success!");
      document
        .querySelectorAll("afterLogin")[0]
        .setAttribute("class", "invisible");
      document
        .querySelectorAll("afterLogin")[1]
        .setAttribute("class", "invisible");
    }
  });
};
