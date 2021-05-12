export default {
    template: `
    <div id="#app">
        <h1>책 등록!!</h1>
        <table border="1">
            <tr>
                <th>제목</th>
                <th>저자</th>
                <th>설명</th>
            </tr>
            <tr>
                <td>
                    <input type="text" v-model="title" placeholder="제목">
                </td>
                <td>
                    <input type="text" v-model="writer" placeholder="글쓴이">
                </td>
                <td>
                    <input type="text" v-model="content" placeholder="내용">
                </td>
            </tr>
            <tr>
                <button @click="regist">작성완료</button>
            </tr>
        </table>
    </div>
    `,
    data() {
        return {
            title:'',
            writer:'',
            content:'',
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
    methods: {
        regist() {
            console.log(this.title);
            console.log(this.writer);
            console.log(this.content);
            axios({
                method: 'post',
                url: 'http://localhost:8080/book/book',
                data: {
                    btitle: this.title,
                    bwriter: this.writer,
                    bcontent: this.content,
                }
            });
            location.href="index.html";
        }
    }

}