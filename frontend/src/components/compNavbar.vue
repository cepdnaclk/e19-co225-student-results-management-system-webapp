<template>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#"><font-awesome-icon icon="fa-solid fa-user-graduate"
                    style="margin-right: 7px;" />Academetrix</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <ul class="navbar-nav ms-auto">
                    <slot></slot>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
</script>

<style scoped>
.navbar {
    background: #2c3e50;
    height: 75px;
}

.navbar-brand {
    color: white;
    font-weight: 600;
}

:slotted(.nav-item:hover) {
    font-weight: 400 !important;
}

:slotted(.navbar a.router-link-active.router-link-exact-active) {
    color: white !important;
    font-weight: 500 !important;
}
</style>