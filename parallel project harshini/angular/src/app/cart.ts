export class Cart {
    constructor(
        public cartId: number,
        public userId: number,
        public emailId: string,
        public productId: number,
        public productCategory: string,
        public productName: string,
        public productPrice: number,
        public quantity: number,

    ) { }
}
