export default {
    template:`
    <div id="app">
        <h1> 대전 5반의 게시판 </h1>
        <table border="1">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
            <tr v-for="bbb in mydata.bList">
                <td v-text="bbb.bnum"></td>
                <td><a v-bind:href="'read.html?bnum='+bbb.bnum">{{bbb.btitle}}<button @click="read($event)">읽기</button></td>
                <td v-text="bbb.bwriter"></td>
            </tr>
        </table>
        <ul>
            <li v-for="bbb in mydata">{{bbb.title}}</li>
        </ul>
    </div>
    `,
    data() {
        return {
            mydata:'',
        }
    },
    created() {
        axios
        .get("http://182.224.88.49:9999/bootboard/boardMain")
        .then((resp) => {
            console.log(resp);
            this.mydata = resp.data;
        });
    },
}
const bus = new Vue();
    Vue.component('child-comp', {
        template: '',
        data() {
            return {
                bnum: '',
            };
        },
        methods: {
            read(event) {
                console.log('check');
                bus.$emit('readBoard', this.bnum);
            }
        }
    })


