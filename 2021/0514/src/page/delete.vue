<template>
  <div>
      <h3>삭제 중입니다.</h3>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    name: "delete",
    created() {
        axios.delete(`http://localhost:9999/vue/api/board/${this.$route.params.no}`)
        .then(({data}) => {
            let msg = '삭제 처리시 문제가 발생했습니다.';
            if (data === 'success') {
                msg = '삭제가 완료되었습니다.';
            }
            alert(msg);
            this.$router.push('/board/list');
        }).catch(() => {
            alert('삭제 처리시 에러가 발생했습니다.');
        });
    }
}
</script>

<style>

</style>