export default {
    template : `
    <div id="app">
    <table border="1">
        <tr>
            <th>제목</th>
            <th>글쓴이</th>
            <th>내용</th>
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

    },
    props:['bus'],
    methods: {
        regist() {
            console.log(this.title);
            console.log(this.writer);
            console.log(this.content);
            axios({
                method: 'post',
                url: 'http://182.224.88.49:9999/bootboard/board',
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