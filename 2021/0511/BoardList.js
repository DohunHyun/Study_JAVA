export default {
    template: `
    <div id="app">
        <h1> 대전 5반의 게시판 </h1>
        <table border="1">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
            <tr v-for="bbb in mydata.bList">
                <td v-text="bbb.bnum" :text="bnum"></td>
                <td>{{bbb.btitle}}<button id="bnum" @click="read($event)">읽기</button></td>
                <td v-text="bbb.bwriter"></td>
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
    created() {
        axios.get("http://182.224.88.49:9999/bootboard/boardMain")
        .then((resp) => {
            console.log(resp);
            this.mydata = resp.data;
        });
    },
    props:['bus'],
    methods: {
        read(event) {
            this.bus.$emit('readBoard', event.currentTarget.id);
            console.log(event.currentTarget.id);
            console.log(this.bnum);
        }
    },

}