export class LoginResponse {
    constructor(
        public statusCode: number,
        public message: string,
        public description: string,
        public role: string

    ) { }
}
