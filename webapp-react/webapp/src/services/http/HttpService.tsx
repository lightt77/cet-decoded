export default class HttpService {
    public static get(url: string): Promise<any> {
        return fetch(url);
    }
}
