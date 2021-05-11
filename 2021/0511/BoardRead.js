export default {
    template: `
    <div id="app">
        <h1> 대전 5반의 게시판 </h1>
        <table border="1">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>글내용</th>
            </tr>
            <tr :mydata="mydata">
                <td v-text="mydata.bnum"></td>
                <td v-text="mydata.title"></td>
                <td v-text="mydata.bwriter"></td>
                <td v-text="mydata.bcontent"></td>
            </tr>
        </table>
        
    </div>
    `,
    data() {
        return {
            mydata:'',
            bnum:'',
        }
    },
    
    props:['bus'],
    methods: {
        read(receive) {
            console.log(receive);
            this.bnum = receive;
        }
    },
    created() {
        axios
        .get("http://182.224.88.49:9999/bootboard/board", {
            params: {
                bnum: 1,
            }
        } )
        .then((resp) => {
            console.log(resp);
            this.mydata = resp.data;
        });
        this.bus.$on('readBoard', this.read);
    },
}