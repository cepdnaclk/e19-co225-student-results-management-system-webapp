<template>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <ul class="list-inline text-center">
                        <li class="list-inline-item"><router-link to="#">License</router-link></li>
                        <li class="list-inline-item"><router-link to="#">Terms</router-link></li>
                        <li class="list-inline-item"><router-link to="#">Privacy</router-link></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="copyright">©Academetrix 2023</div>
    </footer>
</template>

<style scope>
footer {
    background-color: #2c3e50;
    padding: 0;
    text-align: center;
    font-size: 14px;
    justify-content: center;
    align-items: center;
    margin-top: auto;
    position: relative;
}

.list-inline-item {
    text-align: center;
    padding: 20px 5px;
    margin: 10px;
    color: white;
}

.list-inline li {
    display: inline-block;
    margin-right: 10px;
}

.list-inline li a {
    text-decoration: none;
    color: rgba(255, 255, 255, 0.5);
    font-weight: 400;
}

.list-inline li a:hover {
    color: white;
}

.copyright {
    position: absolute;
    bottom: 0.5rem;
    left: 50%;
    transform: translateX(-50%);
    color: white;
    font-size: 0.7rem;
}
</style>