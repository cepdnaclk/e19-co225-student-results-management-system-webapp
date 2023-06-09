<template>
    <input type="checkbox" @input="$emit('update:modelValue', $event.target.checked)" :value="modelValue" :id="props.id">
    <label for="rem"><span></span>
        <slot></slot>
    </label>
</template>

<script setup>
import { defineProps, defineEmits } from 'vue'

const props = defineProps(['id', 'text', 'modelValue'])
defineEmits(['update:modelValue'])
</script>

<style scoped>
input {
    display: none;
}

label {
    display: flex;
    align-items: center;
    font-weight: 300;
    cursor: pointer;
    height: 1.5em;
}

label span {
    display: block;
    height: 1em;
    width: 1em;
    background: white;
    border: 1px solid #B6B6B6;
    border-radius: 3px;
    margin-right: 5px;
    background-size: contain;
}

input:checked+label span {
    background-image: url('@/assets/check.png');
}
</style>