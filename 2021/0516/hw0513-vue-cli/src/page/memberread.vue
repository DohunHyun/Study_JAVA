<template>
    <div>
        <table class="table table-bordered w-50">
            <tr>
                <th>번호</th>
                <td>{{ this.item.id }}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>{{ this.item.name }}</td>
            </tr>
            <tr>
                <th>직급</th>
                <td>{{ this.item.title }}</td>
            </tr>
            <tr>
                <th>월급</th>
                <td>{{ this.item.salary }}</td>
            </tr>
            <tr>
                <th>부서</th>
                <td>{{ this.item.deptName }}</td>
            </tr>
            <tr>
            </tr>
        </table>
        <br />

        <div class="text-center">
            <router-link to="/member/list"
                ><button class="btn btn-primary">목록</button></router-link
            >
            <router-link :to="`/member/update/${this.item.id}`"
                ><button class="btn btn-primary">수정</button></router-link
            >
            <router-link :to="`/member/delete/${this.item.id}`"
                ><button class="btn btn-primary">삭제</button></router-link
            >
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'read',
    components: {
        
    },
    data: function() {
        return {
        item: {},
        };
    },
    created() {
        // console.log('read');
        axios.get(`http://localhost:9998/bootemp/employee/${this.$route.params.id}`)
        .then(({ data }) => {
        this.item = data;
        // console.dir(data);
        console.log(data);
        });
    },
};
</script>

<style></style>
