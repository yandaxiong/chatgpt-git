import type { AxiosProgressEvent, GenericAbortSignal } from 'axios'
import {get, post} from '@/utils/request'
import { getLocalState } from '@/store/modules/user/helper'

export function fetchChatAPI<T = any>(
  prompt: string,
  options?: { conversationId?: string; parentMessageId?: string },
  signal?: GenericAbortSignal,
) {
  const { apiKey } = getLocalState().userInfo
  return post<T>({
    url: '/chat',
    data: { prompt, options: { ...options, apiKey } },
    signal,
  })
}

export function fetchChatConfig<T = any>() {
  return post<T>({
    url: '/config',
  })
}

export function fetchChatAPIProcess<T = any>(
  params: {
    prompt?: string
    message: any
    options?: { conversationId?: string; parentMessageId?: string }
    type: string
    signal?: GenericAbortSignal
    onDownloadProgress?: (progressEvent: AxiosProgressEvent) => void
  },
) {
  const { apiKey } = getLocalState().userInfo

  return post<T>({
    url: `/xinqiu/api/xinqiu/send`,
    data: { message: params.message, type: params.type, apiKey, options: { ...params.options } },
    signal: params.signal,
    onDownloadProgress: params.onDownloadProgress,
  })
}

export function fetchSession<T>() {
  return post<T>({
    url: '/session',
  })
}
export function getConfigs<T>() {
  return get<T>({
    url: '/xinqiu/api/configs',
  })
}

export function fetchPrompts<T>() {
  return get<T>({
    url: '/xinqiu/api/xinqiu/prompts',
  })
}

export function fetchVerify<T>(token: string) {
  return post<T>({
    url: '/verify',
    data: { token },
  })
}
