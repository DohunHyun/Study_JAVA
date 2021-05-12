export default {
    template: `
    <div id="app">
        <table border="1">
            <tr>
                <th>작성자</th>
                <th>내용</th>
            </tr>
            <tr>
                <td>
                    <input type="text" v-model="writer" placeholder="작성자">
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
            bnum: '',
            writer:'',
            content:'',
        }
    },
    created() {
        this.bus.$on('read', this.numSet)
    },
    props:['bus'],
    methods: {
        numSet(receive) {
            this.bnum = receive;
        },
        regist() {
            console.log('gg');
            axios({
                method:'post',
                url:"http://182.224.88.49:9999/bootboard/ajax",
                data: {
                    bnum: this.bnum,
                    cwriter: this.writer,
                    ccontent: this.content,
                }
            })
        },
    },
}