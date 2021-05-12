export default {
    template: `
    <div id="app">
        <table border="1">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
            <tr v-for="bbb in mydata.bList">
                <td>{{bbb.bnum}}</td>
                <td>
                    {{bbb.btitle}}
                    <button @click="read(bbb.bnum)">읽기</button>
                </td>
                <td>{{bbb.bwriter}}</td>
            </tr>
        </table>
    </div>
    `,
    data() {
        return {
            mydata:'',
        }
    },
    created() {
        axios.get("http://182.224.88.49:9999/bootboard/boardMain")
        .then((resp) => {
            console.log(resp);
            this.mydata = resp.data;
        })
    },
    props:['bus'],
    methods: {
        read(receive) {
            console.log(receive);
            this.bus.$emit('read', receive);
        },
    }

}