export default {
    template: `
    <div id="app">
        <table border="1">
            <tr>
                <th>번호</th>
                <th>작성자</th>
                <th>내용</th>
                <th>작성시간</th>
            </tr>
            <tr v-for="bbb in mydata">
                <th>{{bbb.cnum}}</th>
                <th>{{bbb.cwriter}}</th>
                <th>{{bbb.ccontent}}</th>
                <th>{{bbb.cregdate}}</th>
            </tr>
        </table>
    </div>
    `,
    data() {
        return {
            mydata:'',
        }
    },
    props:['bus'],
    methods: {
        commentview(receive) {
            console.log(receive);
            axios.get("http://182.224.88.49:9999/bootboard/ajax?bnum="+receive)
            .then((resp) => {
                console.log(resp);
                this.mydata = resp.data;
            });
        }
    },
    created() {
        this.bus.$on('read', this.commentview);
    },
}