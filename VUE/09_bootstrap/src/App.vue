<!-- <template>
  <div>
    <b-badge variant="primary">Primary</b-badge>
    <b-badge variant="secondary">Secondary</b-badge>
    <b-badge variant="success">Success</b-badge>
    <b-badge variant="danger">Danger</b-badge>
    <b-badge variant="warning">Warning</b-badge>
    <b-badge variant="info">Info</b-badge>
    <b-badge variant="light">Light</b-badge>
    <b-badge variant="dark">Dark</b-badge>
  </div>
</template>

<script setup>

</script>

<style scoped>

</style> -->

<template>
  <div>
    <b-form-group label="Select calendar interactive state" v-slot="{ ariaDescribedby }">
      <b-form-radio-group
        v-model="state"
        :aria-describedby="ariaDescribedby"
        aria-controls="ex-disabled-readonly"
      >
        <b-form-radio value="disabled">Disabled</b-form-radio>
        <b-form-radio value="readonly">Readonly</b-form-radio>
        <b-form-radio value="normal">Normal</b-form-radio>
      </b-form-radio-group>
    </b-form-group>

    <b-calendar
      id="ex-disabled-readonly"
      :disabled="disabled"
      :readonly="readonly"
    ></b-calendar>
  </div>
</template>

<script>
  
  export default {
    data() {
      return {
        state: 'disabled'
      }
    },
    computed: {
      disabled() {
        return this.state === 'disabled'
      },
      readonly() {
        return this.state === 'readonly'
      }
    }
  }
</script>
