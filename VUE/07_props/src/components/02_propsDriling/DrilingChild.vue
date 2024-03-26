<template>
    <h2>child: {{ injectCount }}</h2>
    <GrandChild/>

</template>

<script setup>
    import {inject} from 'vue';
    import GrandChild from './DrilingGrandChild.vue';


    const injectCount = inject('count');

</script>
