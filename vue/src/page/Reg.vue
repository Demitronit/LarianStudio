<script setup>
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';
import RegBody from '@/components/RegBody.vue';
</script>

<template>
  <div class="fon">
    <Header /><router-view></router-view>
    <RegBody /><router-view></router-view>
    <Footer /><router-view></router-view>

  </div>
</template>

<style scoped>
.fon{
  background: url(../assets/back.jpg) no-repeat;
  background-size: 100%;
  
}
</style>



