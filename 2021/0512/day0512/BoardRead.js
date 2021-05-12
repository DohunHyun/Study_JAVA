export default {
    template: `
    <div id="app">
        <table border="1">
            <tr>
                <th>글번호</th>
                <th>글제목</th>
                <th>작성자</th>
                <th>글내용</th>
            </tr>
            <tr>
                <td>{{board.bnum}}</td>
                <td>{{board.btitle}}</td>
                <td>{{board.bwriter}}</td>
                <td>{{board.bcontent}}</td>
            </tr>
        </table>
    </div>
    `,
    data() {
        return {
            board:'',
        }
    },
    props:['bus'],
    methods: {
        view(receive) {
            console.log(receive);
            axios.get("http://182.224.88.49:9999/bootboard/board?bnum="+receive)
            .then((resp) => {
                console.log(resp);
                this.board = resp.data;
            });
        }
    },
    created() {
        this.bus.$on('read', this.view);
    },
}