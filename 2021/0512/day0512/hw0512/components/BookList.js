export default {
    template: `
    <div id="#app">
        <h1>책 목록!!</h1>
        <table border="1">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>저자</th>
                <th>설명</th>
            </tr>
            <tr v-for="book in bookList">
                <td>{{book.bnum}}</td>
                <td>{{book.btitle}}</td>
                <td>{{book.bwriter}}</td>
                <td>{{book.bcontent}}</td>
            </tr>

        </table>
    </div>
    `,
    data() {
        return {
            bookList:'',
        }
    },
    created() {
        axios
        .get("http://localhost:8080/book/bookMain")
        .then((resp) => {
            console.log(resp);
            this.bookList = resp.data.bList;
        })
    },

}