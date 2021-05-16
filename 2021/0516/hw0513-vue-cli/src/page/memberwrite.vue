<template>
    <div>
        <div>
            <label for="writer">이름</label>
            <input 
                type="text" 
                class="form-control"
                id="name"
                ref="name"
                placeholder="작성자를 입력해주세요"
                v-model="name"
            />
        </div>
        <div class="form-group">
            <label for="title">직급</label>
            <input
                type="text"
                class="form-control"
                id="title"
                ref="title"
                placeholder="직급을 입력하세요"
                v-model="title"
            />
        </div>
        <div class="form-group">
            <label for="salary">월급</label>
            <textarea
                type="text"
                class="form-control"
                id="salary"
                ref="salary"
                placeholder="월급을 입력하세요"
                v-model="salary"
            ></textarea>
        </div>
        <div class="form-group">
            <label for="deptName">부서</label>
            <textarea
                type="text"
                class="form-control"
                id="deptName"
                ref="deptName"
                placeholder="부서를 입력하세요"
                v-model="deptName"
            ></textarea>
        </div>
        <div>
            <button @click="checkHandler">등록</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'write',
    components: {

    },
    data() {
        return {
            name: '',
            salary: '',
            title: '',
            deptName: '',
        }
    },
    methods: {
        checkHandler() {
            let err = true;
            let msg = '';
            !this.name &&
            ((msg = '이름을 입력해주세요'),
            (err = false),
            this.$refs.name.focus());
        err &&
            !this.title &&
            ((msg = '직급을 입력해주세요'), (err = false), this.$refs.title.focus());
        err &&
            !this.salary &&
            ((msg = '월급을 입력해주세요'),
            (err = false),
            this.$refs.salary.focus());
            err &&
            !this.deptName &&
            ((msg = '부서명을 입력해주세요'),
            (err = false),
            this.$refs.deptName.focus());
            if (!err) alert(msg);
            else
            axios.post("http://localhost:9998/bootemp/employee", {
                name: this.name,
                salary: this.salary,
                title: this.title,
                deptName: this.deptName,
            })
            .then(({ data }) => {
                let msg = '등록 처리시 문제가 발생했습니다.';
                if (data === 'success') {
                    msg = '등록이 완료되었습니다.';
                }
                alert(msg);
                this.moveList();
            })
            .catch(() => {
                alert('등록 처리시 에러가 발생했습니다.');
            });
        },
        moveList() {
            this.$router.push('/member/list');
        }

    },
    created() {

    },
}
</script>

<style>

</style>